                                                                    															
/*
 * Java business for entity table stock_audit 
 * Created on 2025-02-15 ( Time 03:02:47 )
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
import dev.backend.epharmaApp.dao.entity.StockAudit;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "stock_audit"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class StockAuditBusiness implements IBasicBusiness<Request<StockAuditDto>, Response<StockAuditDto>> {

	private Response<StockAuditDto> response;
	@Autowired
	private StockAuditRepository stockAuditRepository;
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

	public StockAuditBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create StockAudit by using StockAuditDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAuditDto> create(Request<StockAuditDto> request, Locale locale)  throws ParseException {
		log.info("----begin create StockAudit-----");

		Response<StockAuditDto> response = new Response<StockAuditDto>();
		List<StockAudit>        items    = new ArrayList<StockAudit>();
			
		for (StockAuditDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			fieldsToVerify.put("productId", dto.getProductId());
			fieldsToVerify.put("oldQuantity", dto.getOldQuantity());
			fieldsToVerify.put("newQuantity", dto.getNewQuantity());
			fieldsToVerify.put("changeDate", dto.getChangeDate());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if stockAudit to insert do not exist
			StockAudit existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("stockAudit auditId -> " + dto.getAuditId(), locale));
				response.setHasError(true);
				return response;
			}

				StockAudit entityToSave = null;
			entityToSave = StockAuditTransformer.INSTANCE.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<StockAudit> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = stockAuditRepository.saveAll((Iterable<StockAudit>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("stockAudit", locale));
				response.setHasError(true);
				return response;
			}
			List<StockAuditDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockAuditTransformer.INSTANCE.toLiteDtos(itemsSaved) : StockAuditTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create StockAudit-----");
		return response;
	}

	/**
	 * update StockAudit by using StockAuditDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAuditDto> update(Request<StockAuditDto> request, Locale locale)  throws ParseException {
		log.info("----begin update StockAudit-----");

		Response<StockAuditDto> response = new Response<StockAuditDto>();
		List<StockAudit>        items    = new ArrayList<StockAudit>();
			
		for (StockAuditDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("auditId", dto.getAuditId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la stockAudit existe
			StockAudit entityToSave = null;
			entityToSave = stockAuditRepository.findOne(dto.getAuditId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stockAudit auditId -> " + dto.getAuditId(), locale));
				response.setHasError(true);
				return response;
			}

			if (dto.getPharmacyId() != null && dto.getPharmacyId() > 0) {
				entityToSave.setPharmacyId(dto.getPharmacyId());
			}
			if (dto.getProductId() != null && dto.getProductId() > 0) {
				entityToSave.setProductId(dto.getProductId());
			}
			if (dto.getOldQuantity() != null && dto.getOldQuantity() > 0) {
				entityToSave.setOldQuantity(dto.getOldQuantity());
			}
			if (dto.getNewQuantity() != null && dto.getNewQuantity() > 0) {
				entityToSave.setNewQuantity(dto.getNewQuantity());
			}
			if (Utilities.notBlank(dto.getChangeDate())) {
				entityToSave.setChangeDate(dateFormat.parse(dto.getChangeDate()));
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
			List<StockAudit> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = stockAuditRepository.saveAll((Iterable<StockAudit>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("stockAudit", locale));
				response.setHasError(true);
				return response;
			}
			List<StockAuditDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockAuditTransformer.INSTANCE.toLiteDtos(itemsSaved) : StockAuditTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update StockAudit-----");
		return response;
	}

	/**
	 * delete StockAudit by using StockAuditDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAuditDto> delete(Request<StockAuditDto> request, Locale locale)  {
		log.info("----begin delete StockAudit-----");

		Response<StockAuditDto> response = new Response<StockAuditDto>();
		List<StockAudit>        items    = new ArrayList<StockAudit>();
			
		for (StockAuditDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("auditId", dto.getAuditId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la stockAudit existe
			StockAudit existingEntity = null;
			existingEntity = stockAuditRepository.findOne(dto.getAuditId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stockAudit -> " + dto.getAuditId(), locale));
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
			stockAuditRepository.saveAll((Iterable<StockAudit>) items);

			response.setHasError(false);
		}

		log.info("----end delete StockAudit-----");
		return response;
	}

	/**
	 * get StockAudit by using StockAuditDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAuditDto> getByCriteria(Request<StockAuditDto> request, Locale locale)  throws Exception {
		log.info("----begin get StockAudit-----");

		Response<StockAuditDto> response = new Response<StockAuditDto>();
		List<StockAudit> items 			 = stockAuditRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<StockAuditDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockAuditTransformer.INSTANCE.toLiteDtos(items) : StockAuditTransformer.INSTANCE.toDtos(items);

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
			response.setCount(stockAuditRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("stockAudit", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get StockAudit-----");
		return response;
	}

	/**
	 * get full StockAuditDto by using StockAudit as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private StockAuditDto getFullInfos(StockAuditDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
