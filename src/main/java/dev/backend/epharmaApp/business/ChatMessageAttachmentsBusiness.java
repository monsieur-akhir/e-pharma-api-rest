                                                                														
/*
 * Java business for entity table chat_message_attachments 
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
import dev.backend.epharmaApp.dao.entity.ChatMessageAttachments;
import dev.backend.epharmaApp.dao.entity.ChatMessages;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "chat_message_attachments"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ChatMessageAttachmentsBusiness implements IBasicBusiness<Request<ChatMessageAttachmentsDto>, Response<ChatMessageAttachmentsDto>> {

	private Response<ChatMessageAttachmentsDto> response;
	@Autowired
	private ChatMessageAttachmentsRepository chatMessageAttachmentsRepository;
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

	public ChatMessageAttachmentsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ChatMessageAttachments by using ChatMessageAttachmentsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatMessageAttachmentsDto> create(Request<ChatMessageAttachmentsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create ChatMessageAttachments-----");

		Response<ChatMessageAttachmentsDto> response = new Response<ChatMessageAttachmentsDto>();
		List<ChatMessageAttachments>        items    = new ArrayList<ChatMessageAttachments>();
			
		for (ChatMessageAttachmentsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("messageId", dto.getMessageId());
			fieldsToVerify.put("fileType", dto.getFileType());
			fieldsToVerify.put("fileName", dto.getFileName());
			fieldsToVerify.put("fileData", dto.getFileData());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if chatMessageAttachments to insert do not exist
			ChatMessageAttachments existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("chatMessageAttachments attachmentId -> " + dto.getAttachmentId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if chatMessages exist
			ChatMessages existingChatMessages = null;
			if (dto.getMessageId() != null && dto.getMessageId() > 0){
				existingChatMessages = chatMessagesRepository.findOne(dto.getMessageId(), false);
				if (existingChatMessages == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("chatMessages messageId -> " + dto.getMessageId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				ChatMessageAttachments entityToSave = null;
			entityToSave = ChatMessageAttachmentsTransformer.INSTANCE.toEntity(dto, existingChatMessages);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ChatMessageAttachments> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = chatMessageAttachmentsRepository.saveAll((Iterable<ChatMessageAttachments>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("chatMessageAttachments", locale));
				response.setHasError(true);
				return response;
			}
			List<ChatMessageAttachmentsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatMessageAttachmentsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ChatMessageAttachmentsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create ChatMessageAttachments-----");
		return response;
	}

	/**
	 * update ChatMessageAttachments by using ChatMessageAttachmentsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatMessageAttachmentsDto> update(Request<ChatMessageAttachmentsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update ChatMessageAttachments-----");

		Response<ChatMessageAttachmentsDto> response = new Response<ChatMessageAttachmentsDto>();
		List<ChatMessageAttachments>        items    = new ArrayList<ChatMessageAttachments>();
			
		for (ChatMessageAttachmentsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("attachmentId", dto.getAttachmentId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la chatMessageAttachments existe
			ChatMessageAttachments entityToSave = null;
			entityToSave = chatMessageAttachmentsRepository.findOne(dto.getAttachmentId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatMessageAttachments attachmentId -> " + dto.getAttachmentId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if chatMessages exist
			if (dto.getMessageId() != null && dto.getMessageId() > 0){
				ChatMessages existingChatMessages = chatMessagesRepository.findOne(dto.getMessageId(), false);
				if (existingChatMessages == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("chatMessages messageId -> " + dto.getMessageId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setChatMessages(existingChatMessages);
			}
			if (Utilities.notBlank(dto.getFileType())) {
				entityToSave.setFileType(dto.getFileType());
			}
			if (Utilities.notBlank(dto.getFileName())) {
				entityToSave.setFileName(dto.getFileName());
			}
			if (Utilities.notBlank(dto.getFileData())) {
				entityToSave.setFileData(dto.getFileData());
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
			List<ChatMessageAttachments> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = chatMessageAttachmentsRepository.saveAll((Iterable<ChatMessageAttachments>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("chatMessageAttachments", locale));
				response.setHasError(true);
				return response;
			}
			List<ChatMessageAttachmentsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatMessageAttachmentsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ChatMessageAttachmentsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update ChatMessageAttachments-----");
		return response;
	}

	/**
	 * delete ChatMessageAttachments by using ChatMessageAttachmentsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatMessageAttachmentsDto> delete(Request<ChatMessageAttachmentsDto> request, Locale locale)  {
		log.info("----begin delete ChatMessageAttachments-----");

		Response<ChatMessageAttachmentsDto> response = new Response<ChatMessageAttachmentsDto>();
		List<ChatMessageAttachments>        items    = new ArrayList<ChatMessageAttachments>();
			
		for (ChatMessageAttachmentsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("attachmentId", dto.getAttachmentId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la chatMessageAttachments existe
			ChatMessageAttachments existingEntity = null;
			existingEntity = chatMessageAttachmentsRepository.findOne(dto.getAttachmentId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("chatMessageAttachments -> " + dto.getAttachmentId(), locale));
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
			chatMessageAttachmentsRepository.saveAll((Iterable<ChatMessageAttachments>) items);

			response.setHasError(false);
		}

		log.info("----end delete ChatMessageAttachments-----");
		return response;
	}

	/**
	 * get ChatMessageAttachments by using ChatMessageAttachmentsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ChatMessageAttachmentsDto> getByCriteria(Request<ChatMessageAttachmentsDto> request, Locale locale)  throws Exception {
		log.info("----begin get ChatMessageAttachments-----");

		Response<ChatMessageAttachmentsDto> response = new Response<ChatMessageAttachmentsDto>();
		List<ChatMessageAttachments> items 			 = chatMessageAttachmentsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ChatMessageAttachmentsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ChatMessageAttachmentsTransformer.INSTANCE.toLiteDtos(items) : ChatMessageAttachmentsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(chatMessageAttachmentsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("chatMessageAttachments", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get ChatMessageAttachments-----");
		return response;
	}

	/**
	 * get full ChatMessageAttachmentsDto by using ChatMessageAttachments as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ChatMessageAttachmentsDto getFullInfos(ChatMessageAttachmentsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
