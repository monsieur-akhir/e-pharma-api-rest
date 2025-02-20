                                                                        																
/*
 * Java business for entity table prescription_items 
 * Created on 2025-02-15 ( Time 03:02:44 )
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
import dev.backend.epharmaApp.dao.entity.PrescriptionItems;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.Prescriptions;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "prescription_items"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class PrescriptionItemsBusiness implements IBasicBusiness<Request<PrescriptionItemsDto>, Response<PrescriptionItemsDto>> {

	private Response<PrescriptionItemsDto> response;
	@Autowired
	private PrescriptionItemsRepository prescriptionItemsRepository;
	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private PrescriptionsRepository prescriptionsRepository;
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

	public PrescriptionItemsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create PrescriptionItems by using PrescriptionItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionItemsDto> create(Request<PrescriptionItemsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create PrescriptionItems-----");

		Response<PrescriptionItemsDto> response = new Response<PrescriptionItemsDto>();
		List<PrescriptionItems>        items    = new ArrayList<PrescriptionItems>();
			
		for (PrescriptionItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("prescriptionId", dto.getPrescriptionId());
			fieldsToVerify.put("productId", dto.getProductId());
			fieldsToVerify.put("dosage", dto.getDosage());
			fieldsToVerify.put("frequency", dto.getFrequency());
			fieldsToVerify.put("duration", dto.getDuration());
			fieldsToVerify.put("notes", dto.getNotes());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if prescriptionItems to insert do not exist
			PrescriptionItems existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prescriptionItems prescriptionItemId -> " + dto.getPrescriptionItemId(), locale));
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
			// Verify if prescriptions exist
			Prescriptions existingPrescriptions = null;
			if (dto.getPrescriptionId() != null && dto.getPrescriptionId() > 0){
				existingPrescriptions = prescriptionsRepository.findOne(dto.getPrescriptionId(), false);
				if (existingPrescriptions == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prescriptions prescriptionId -> " + dto.getPrescriptionId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				PrescriptionItems entityToSave = null;
			entityToSave = PrescriptionItemsTransformer.INSTANCE.toEntity(dto, existingProducts, existingPrescriptions);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PrescriptionItems> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = prescriptionItemsRepository.saveAll((Iterable<PrescriptionItems>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prescriptionItems", locale));
				response.setHasError(true);
				return response;
			}
			List<PrescriptionItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrescriptionItemsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrescriptionItemsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create PrescriptionItems-----");
		return response;
	}

	/**
	 * update PrescriptionItems by using PrescriptionItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionItemsDto> update(Request<PrescriptionItemsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update PrescriptionItems-----");

		Response<PrescriptionItemsDto> response = new Response<PrescriptionItemsDto>();
		List<PrescriptionItems>        items    = new ArrayList<PrescriptionItems>();
			
		for (PrescriptionItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("prescriptionItemId", dto.getPrescriptionItemId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prescriptionItems existe
			PrescriptionItems entityToSave = null;
			entityToSave = prescriptionItemsRepository.findOne(dto.getPrescriptionItemId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prescriptionItems prescriptionItemId -> " + dto.getPrescriptionItemId(), locale));
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
			// Verify if prescriptions exist
			if (dto.getPrescriptionId() != null && dto.getPrescriptionId() > 0){
				Prescriptions existingPrescriptions = prescriptionsRepository.findOne(dto.getPrescriptionId(), false);
				if (existingPrescriptions == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prescriptions prescriptionId -> " + dto.getPrescriptionId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setPrescriptions(existingPrescriptions);
			}
			if (Utilities.notBlank(dto.getDosage())) {
				entityToSave.setDosage(dto.getDosage());
			}
			if (Utilities.notBlank(dto.getFrequency())) {
				entityToSave.setFrequency(dto.getFrequency());
			}
			if (Utilities.notBlank(dto.getDuration())) {
				entityToSave.setDuration(dto.getDuration());
			}
			if (Utilities.notBlank(dto.getNotes())) {
				entityToSave.setNotes(dto.getNotes());
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
			List<PrescriptionItems> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = prescriptionItemsRepository.saveAll((Iterable<PrescriptionItems>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prescriptionItems", locale));
				response.setHasError(true);
				return response;
			}
			List<PrescriptionItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrescriptionItemsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrescriptionItemsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update PrescriptionItems-----");
		return response;
	}

	/**
	 * delete PrescriptionItems by using PrescriptionItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionItemsDto> delete(Request<PrescriptionItemsDto> request, Locale locale)  {
		log.info("----begin delete PrescriptionItems-----");

		Response<PrescriptionItemsDto> response = new Response<PrescriptionItemsDto>();
		List<PrescriptionItems>        items    = new ArrayList<PrescriptionItems>();
			
		for (PrescriptionItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("prescriptionItemId", dto.getPrescriptionItemId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prescriptionItems existe
			PrescriptionItems existingEntity = null;
			existingEntity = prescriptionItemsRepository.findOne(dto.getPrescriptionItemId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prescriptionItems -> " + dto.getPrescriptionItemId(), locale));
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
			prescriptionItemsRepository.saveAll((Iterable<PrescriptionItems>) items);

			response.setHasError(false);
		}

		log.info("----end delete PrescriptionItems-----");
		return response;
	}

	/**
	 * get PrescriptionItems by using PrescriptionItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionItemsDto> getByCriteria(Request<PrescriptionItemsDto> request, Locale locale)  throws Exception {
		log.info("----begin get PrescriptionItems-----");

		Response<PrescriptionItemsDto> response = new Response<PrescriptionItemsDto>();
		List<PrescriptionItems> items 			 = prescriptionItemsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PrescriptionItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrescriptionItemsTransformer.INSTANCE.toLiteDtos(items) : PrescriptionItemsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(prescriptionItemsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("prescriptionItems", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get PrescriptionItems-----");
		return response;
	}

	/**
	 * get full PrescriptionItemsDto by using PrescriptionItems as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PrescriptionItemsDto getFullInfos(PrescriptionItemsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
