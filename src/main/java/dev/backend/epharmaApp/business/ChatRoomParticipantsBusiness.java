                                                    											
/*
 * Java business for entity table chat_room_participants 
 * Created on 2025-02-15 ( Time 03:02:40 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.business;

import dev.backend.epharmaApp.dao.entity.ChatRoomParticipants;
import dev.backend.epharmaApp.dao.entity.ChatRooms;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.repository.ChatRoomParticipantsRepository;
import dev.backend.epharmaApp.dao.repository.ChatRoomsRepository;
import dev.backend.epharmaApp.dao.repository.UsersRepository;
import dev.backend.epharmaApp.utils.*;
import dev.backend.epharmaApp.utils.contract.IBasicBusiness;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.contract.Response;
import dev.backend.epharmaApp.utils.dto.ChatRoomParticipantsDto;
import dev.backend.epharmaApp.utils.dto.transformer.ChatRoomParticipantsTransformer;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
BUSINESS for table "chat_room_participants"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ChatRoomParticipantsBusiness implements IBasicBusiness<Request<ChatRoomParticipantsDto>, Response<ChatRoomParticipantsDto>> {

	private Response<ChatRoomParticipantsDto> response;
	@Autowired
	private ChatRoomParticipantsRepository chatRoomParticipantsRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ChatRoomsRepository chatRoomsRepository;
	@Autowired
	private FunctionalError functionalError;
	@Autowired
	private TechnicalError technicalError;
	@Autowired
	private ExceptionUtils exceptionUtils;
	@PersistenceContext
	private EntityManager em;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTimeFormat;

	public ChatRoomParticipantsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ChatRoomParticipants by using ChatRoomParticipantsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomParticipantsDto> create(Request<ChatRoomParticipantsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create ChatRoomParticipants-----");

		Response<ChatRoomParticipantsDto> response = new Response<ChatRoomParticipantsDto>();
		List<ChatRoomParticipants>        items    = new ArrayList<ChatRoomParticipants>();
			
		for (ChatRoomParticipantsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if chatRoomParticipants to insert do not exist
			ChatRoomParticipants existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("chatRoomParticipants roomId -> " + dto.getRoomId(), locale));
				response.setHasError(true);
				return response;
			}

			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("chatRoomParticipants userId -> " + dto.getUserId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if users exist
			Users existingUsers = null;
			if (dto.getUserId() != null && dto.getUserId() > 0){
				existingUsers = usersRepository.findOne(dto.getUserId(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users userId -> " + dto.getUserId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if chatRooms exist
			ChatRooms existingChatRooms = null;
			if (dto.getRoomId() != null && dto.getRoomId() > 0){
				existingChatRooms = chatRoomsRepository.findOne(dto.getRoomId(), false);
				if (existingChatRooms == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("chatRooms roomId -> " + dto.getRoomId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				ChatRoomParticipants entityToSave = null;
			entityToSave = ChatRoomParticipantsTransformer.INSTANCE.toEntity(dto, existingUsers, existingChatRooms);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ChatRoomParticipants> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = chatRoomParticipantsRepository.saveAll((Iterable<ChatRoomParticipants>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("chatRoomParticipants", locale));
				response.setHasError(true);
				return response;
			}
			List<ChatRoomParticipantsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatRoomParticipantsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ChatRoomParticipantsTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		log.info("----end create ChatRoomParticipants-----");
		return response;
	}

	/**
	 * update ChatRoomParticipants by using ChatRoomParticipantsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomParticipantsDto> update(Request<ChatRoomParticipantsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update ChatRoomParticipants-----");

		Response<ChatRoomParticipantsDto> response = new Response<ChatRoomParticipantsDto>();
		List<ChatRoomParticipants>        items    = new ArrayList<ChatRoomParticipants>();
			
		for (ChatRoomParticipantsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la chatRoomParticipants existe
			ChatRoomParticipants entityToSave = null;
			entityToSave = chatRoomParticipantsRepository.findOneByRoomId(dto.getRoomId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatRoomParticipants roomId -> " + dto.getRoomId(), locale));
				response.setHasError(true);
				return response;
			}
			entityToSave = chatRoomParticipantsRepository.findOneByUsersId(dto.getUserId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatRoomParticipants userId -> " + dto.getUserId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if users exist
			if (dto.getUserId() != null && dto.getUserId() > 0){
				Users existingUsers = usersRepository.findOne(dto.getUserId(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users userId -> " + dto.getUserId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setUsers(existingUsers);
			}
			// Verify if chatRooms exist
			if (dto.getRoomId() != null && dto.getRoomId() > 0){
				ChatRooms existingChatRooms = chatRoomsRepository.findOne(dto.getRoomId(), false);
				if (existingChatRooms == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("chatRooms roomId -> " + dto.getRoomId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setChatRooms(existingChatRooms);
			}
			if (Utilities.notBlank(dto.getRecordStatus())) {
				entityToSave.setRecordStatus(dto.getRecordStatus());
			}
			if (dto.getCreatedBy() != null && dto.getCreatedBy() > 0) {
				entityToSave.setCreatedBy(dto.getCreatedBy());
			}
			if (dto.getUpdatedBy() != null && dto.getUpdatedBy() > 0) {
				entityToSave.setUpdatedBy(dto.getUpdatedBy());
			}
			if (Utilities.notBlank(dto.getDeletedAt())) {
				entityToSave.setDeletedAt(dateFormat.parse(dto.getDeletedAt()));
			}
			if (dto.getDeletedBy() != null && dto.getDeletedBy() > 0) {
				entityToSave.setDeletedBy(dto.getDeletedBy());
			}
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			entityToSave.setUpdatedBy(request.getUser());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ChatRoomParticipants> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = chatRoomParticipantsRepository.saveAll((Iterable<ChatRoomParticipants>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("chatRoomParticipants", locale));
				response.setHasError(true);
				return response;
			}
			List<ChatRoomParticipantsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatRoomParticipantsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ChatRoomParticipantsTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		log.info("----end update ChatRoomParticipants-----");
		return response;
	}

	/**
	 * delete ChatRoomParticipants by using ChatRoomParticipantsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomParticipantsDto> delete(Request<ChatRoomParticipantsDto> request, Locale locale)  {
		log.info("----begin delete ChatRoomParticipants-----");

		Response<ChatRoomParticipantsDto> response = new Response<ChatRoomParticipantsDto>();
		List<ChatRoomParticipants>        items    = new ArrayList<ChatRoomParticipants>();
			
		for (ChatRoomParticipantsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("roomId", dto.getRoomId());
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la chatRoomParticipants existe
			ChatRoomParticipants existingEntity = null;
			existingEntity = chatRoomParticipantsRepository.findOneByRoomId(dto.getRoomId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatRoomParticipants -> " + dto.getRoomId(), locale));
				response.setHasError(true);
				return response;
			}
			existingEntity = chatRoomParticipantsRepository.findOneByUsersId(dto.getUserId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatRoomParticipants -> " + dto.getUserId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------



			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			existingEntity.setDeletedBy(request.getUser());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			chatRoomParticipantsRepository.saveAll((Iterable<ChatRoomParticipants>) items);

			response.setHasError(false);
		}

		log.info("----end delete ChatRoomParticipants-----");
		return response;
	}

	/**
	 * get ChatRoomParticipants by using ChatRoomParticipantsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomParticipantsDto> getByCriteria(Request<ChatRoomParticipantsDto> request, Locale locale)  throws Exception {
		log.info("----begin get ChatRoomParticipants-----");

		Response<ChatRoomParticipantsDto> response = new Response<ChatRoomParticipantsDto>();
		List<ChatRoomParticipants> items 			 = chatRoomParticipantsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ChatRoomParticipantsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatRoomParticipantsTransformer.INSTANCE.toLiteDtos(items) : ChatRoomParticipantsTransformer.INSTANCE.toDtos(items);

			final int size = items.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setCount(chatRoomParticipantsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("chatRoomParticipants", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get ChatRoomParticipants-----");
		return response;
	}

	/**
	 * get full ChatRoomParticipantsDto by using ChatRoomParticipants as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ChatRoomParticipantsDto getFullInfos(ChatRoomParticipantsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
		// put code here

		if (Utilities.isTrue(isSimpleLoading)) {
			return dto;
		}
		if (size > 1) {
			return dto;
		}

		return dto;
	}
}
