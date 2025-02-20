                                                    											
/*
 * Java business for entity table chat_rooms 
 * Created on 2025-02-15 ( Time 03:02:40 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.business;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import dev.backend.epharmaApp.utils.*;
import dev.backend.epharmaApp.utils.dto.*;
import dev.backend.epharmaApp.utils.contract.IBasicBusiness;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.contract.Response;
import dev.backend.epharmaApp.utils.dto.transformer.*;
import dev.backend.epharmaApp.dao.entity.ChatRooms;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "chat_rooms"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ChatRoomsBusiness implements IBasicBusiness<Request<ChatRoomsDto>, Response<ChatRoomsDto>> {

	private Response<ChatRoomsDto> response;
	@Autowired
	private ChatRoomsRepository chatRoomsRepository;
	@Autowired
	private ChatRoomParticipantsRepository chatRoomParticipantsRepository;
	@Autowired
	private ChatMessagesRepository chatMessagesRepository;
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

	public ChatRoomsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ChatRooms by using ChatRoomsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomsDto> create(Request<ChatRoomsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create ChatRooms-----");

		Response<ChatRoomsDto> response = new Response<ChatRoomsDto>();
		List<ChatRooms>        items    = new ArrayList<ChatRooms>();
			
		for (ChatRoomsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("roomName", dto.getRoomName());
			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if chatRooms to insert do not exist
			ChatRooms existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("chatRooms roomId -> " + dto.getRoomId(), locale));
				response.setHasError(true);
				return response;
			}

				ChatRooms entityToSave = null;
			entityToSave = ChatRoomsTransformer.INSTANCE.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ChatRooms> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = chatRoomsRepository.saveAll((Iterable<ChatRooms>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("chatRooms", locale));
				response.setHasError(true);
				return response;
			}
			List<ChatRoomsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatRoomsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ChatRoomsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create ChatRooms-----");
		return response;
	}

	/**
	 * update ChatRooms by using ChatRoomsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomsDto> update(Request<ChatRoomsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update ChatRooms-----");

		Response<ChatRoomsDto> response = new Response<ChatRoomsDto>();
		List<ChatRooms>        items    = new ArrayList<ChatRooms>();
			
		for (ChatRoomsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("roomId", dto.getRoomId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la chatRooms existe
			ChatRooms entityToSave = null;
			entityToSave = chatRoomsRepository.findOne(dto.getRoomId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatRooms roomId -> " + dto.getRoomId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getRoomName())) {
				entityToSave.setRoomName(dto.getRoomName());
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
			List<ChatRooms> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = chatRoomsRepository.saveAll((Iterable<ChatRooms>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("chatRooms", locale));
				response.setHasError(true);
				return response;
			}
			List<ChatRoomsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatRoomsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ChatRoomsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update ChatRooms-----");
		return response;
	}

	/**
	 * delete ChatRooms by using ChatRoomsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomsDto> delete(Request<ChatRoomsDto> request, Locale locale)  {
		log.info("----begin delete ChatRooms-----");

		Response<ChatRoomsDto> response = new Response<ChatRoomsDto>();
		List<ChatRooms>        items    = new ArrayList<ChatRooms>();
			
		for (ChatRoomsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("roomId", dto.getRoomId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la chatRooms existe
			ChatRooms existingEntity = null;
			existingEntity = chatRoomsRepository.findOne(dto.getRoomId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatRooms -> " + dto.getRoomId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// chatRoomParticipants
			List<ChatRoomParticipants> listOfChatRoomParticipants = chatRoomParticipantsRepository.findByRoomId(existingEntity.getRoomId(), false);
			if (listOfChatRoomParticipants != null && !listOfChatRoomParticipants.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfChatRoomParticipants.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// chatMessages
			List<ChatMessages> listOfChatMessages = chatMessagesRepository.findByRoomId(existingEntity.getRoomId(), false);
			if (listOfChatMessages != null && !listOfChatMessages.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfChatMessages.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			existingEntity.setDeletedBy(request.getUser());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			chatRoomsRepository.saveAll((Iterable<ChatRooms>) items);

			response.setHasError(false);
		}

		log.info("----end delete ChatRooms-----");
		return response;
	}

	/**
	 * get ChatRooms by using ChatRoomsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatRoomsDto> getByCriteria(Request<ChatRoomsDto> request, Locale locale)  throws Exception {
		log.info("----begin get ChatRooms-----");

		Response<ChatRoomsDto> response = new Response<ChatRoomsDto>();
		List<ChatRooms> items 			 = chatRoomsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ChatRoomsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatRoomsTransformer.INSTANCE.toLiteDtos(items) : ChatRoomsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(chatRoomsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("chatRooms", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get ChatRooms-----");
		return response;
	}

	/**
	 * get full ChatRoomsDto by using ChatRooms as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ChatRoomsDto getFullInfos(ChatRoomsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
