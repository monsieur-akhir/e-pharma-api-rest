                                                            													
/*
 * Java business for entity table notices 
 * Created on 2025-02-15 ( Time 03:02:42 )
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
import dev.backend.epharmaApp.dao.entity.Notices;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "notices"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class NoticesBusiness implements IBasicBusiness<Request<NoticesDto>, Response<NoticesDto>> {

	private Response<NoticesDto> response;
	@Autowired
	private NoticesRepository noticesRepository;
	@Autowired
	private ProductsRepository productsRepository;
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

	public NoticesBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Notices by using NoticesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<NoticesDto> create(Request<NoticesDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Notices-----");

		Response<NoticesDto> response = new Response<NoticesDto>();
		List<Notices>        items    = new ArrayList<Notices>();
			
		for (NoticesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("productId", dto.getProductId());
			fieldsToVerify.put("title", dto.getTitle());
			fieldsToVerify.put("content", dto.getContent());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if notices to insert do not exist
			Notices existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("notices noticeId -> " + dto.getNoticeId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if products exist
			Products existingProducts = null;
			if (dto.getProductId() != null && dto.getProductId() > 0){
				existingProducts = productsRepository.findOne(dto.getProductId(), false);
				if (existingProducts == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("products productId -> " + dto.getProductId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				Notices entityToSave = null;
			entityToSave = NoticesTransformer.INSTANCE.toEntity(dto, existingProducts);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Notices> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = noticesRepository.saveAll((Iterable<Notices>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("notices", locale));
				response.setHasError(true);
				return response;
			}
			List<NoticesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? NoticesTransformer.INSTANCE.toLiteDtos(itemsSaved) : NoticesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Notices-----");
		return response;
	}

	/**
	 * update Notices by using NoticesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<NoticesDto> update(Request<NoticesDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Notices-----");

		Response<NoticesDto> response = new Response<NoticesDto>();
		List<Notices>        items    = new ArrayList<Notices>();
			
		for (NoticesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("noticeId", dto.getNoticeId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la notices existe
			Notices entityToSave = null;
			entityToSave = noticesRepository.findOne(dto.getNoticeId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("notices noticeId -> " + dto.getNoticeId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if products exist
			if (dto.getProductId() != null && dto.getProductId() > 0){
				Products existingProducts = productsRepository.findOne(dto.getProductId(), false);
				if (existingProducts == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("products productId -> " + dto.getProductId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setProducts(existingProducts);
			}
			if (Utilities.notBlank(dto.getTitle())) {
				entityToSave.setTitle(dto.getTitle());
			}
			if (Utilities.notBlank(dto.getContent())) {
				entityToSave.setContent(dto.getContent());
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
			List<Notices> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = noticesRepository.saveAll((Iterable<Notices>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("notices", locale));
				response.setHasError(true);
				return response;
			}
			List<NoticesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? NoticesTransformer.INSTANCE.toLiteDtos(itemsSaved) : NoticesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Notices-----");
		return response;
	}

	/**
	 * delete Notices by using NoticesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<NoticesDto> delete(Request<NoticesDto> request, Locale locale)  {
		log.info("----begin delete Notices-----");

		Response<NoticesDto> response = new Response<NoticesDto>();
		List<Notices>        items    = new ArrayList<Notices>();
			
		for (NoticesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("noticeId", dto.getNoticeId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la notices existe
			Notices existingEntity = null;
			existingEntity = noticesRepository.findOne(dto.getNoticeId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("notices -> " + dto.getNoticeId(), locale));
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
			noticesRepository.saveAll((Iterable<Notices>) items);

			response.setHasError(false);
		}

		log.info("----end delete Notices-----");
		return response;
	}

	/**
	 * get Notices by using NoticesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<NoticesDto> getByCriteria(Request<NoticesDto> request, Locale locale)  throws Exception {
		log.info("----begin get Notices-----");

		Response<NoticesDto> response = new Response<NoticesDto>();
		List<Notices> items 			 = noticesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<NoticesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? NoticesTransformer.INSTANCE.toLiteDtos(items) : NoticesTransformer.INSTANCE.toDtos(items);

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
			response.setCount(noticesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("notices", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Notices-----");
		return response;
	}

	/**
	 * get full NoticesDto by using Notices as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private NoticesDto getFullInfos(NoticesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
