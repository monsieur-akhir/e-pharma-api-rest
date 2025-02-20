                                                                														
/*
 * Java business for entity table pharmacy_ratings 
 * Created on 2025-02-15 ( Time 03:02:43 )
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
import dev.backend.epharmaApp.dao.entity.PharmacyRatings;
import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "pharmacy_ratings"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class PharmacyRatingsBusiness implements IBasicBusiness<Request<PharmacyRatingsDto>, Response<PharmacyRatingsDto>> {

	private Response<PharmacyRatingsDto> response;
	@Autowired
	private PharmacyRatingsRepository pharmacyRatingsRepository;
	@Autowired
	private ClientsRepository clientsRepository;
	@Autowired
	private PharmaciesRepository pharmaciesRepository;
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

	public PharmacyRatingsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create PharmacyRatings by using PharmacyRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacyRatingsDto> create(Request<PharmacyRatingsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create PharmacyRatings-----");

		Response<PharmacyRatingsDto> response = new Response<PharmacyRatingsDto>();
		List<PharmacyRatings>        items    = new ArrayList<PharmacyRatings>();
			
		for (PharmacyRatingsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			fieldsToVerify.put("clientId", dto.getClientId());
			fieldsToVerify.put("ratingValue", dto.getRatingValue());
			fieldsToVerify.put("comment", dto.getComment());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if pharmacyRatings to insert do not exist
			PharmacyRatings existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("pharmacyRatings ratingId -> " + dto.getRatingId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if clients exist
			Clients existingClients = null;
			if (dto.getClientId() != null && dto.getClientId() > 0){
				existingClients = clientsRepository.findOne(dto.getClientId(), false);
				if (existingClients == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("clients clientId -> " + dto.getClientId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if pharmacies exist
			Pharmacies existingPharmacies = null;
			if (dto.getPharmacyId() != null && dto.getPharmacyId() > 0){
				existingPharmacies = pharmaciesRepository.findOne(dto.getPharmacyId(), false);
				if (existingPharmacies == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("pharmacies pharmacyId -> " + dto.getPharmacyId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				PharmacyRatings entityToSave = null;
			entityToSave = PharmacyRatingsTransformer.INSTANCE.toEntity(dto, existingClients, existingPharmacies);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PharmacyRatings> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = pharmacyRatingsRepository.saveAll((Iterable<PharmacyRatings>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("pharmacyRatings", locale));
				response.setHasError(true);
				return response;
			}
			List<PharmacyRatingsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmacyRatingsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PharmacyRatingsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create PharmacyRatings-----");
		return response;
	}

	/**
	 * update PharmacyRatings by using PharmacyRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacyRatingsDto> update(Request<PharmacyRatingsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update PharmacyRatings-----");

		Response<PharmacyRatingsDto> response = new Response<PharmacyRatingsDto>();
		List<PharmacyRatings>        items    = new ArrayList<PharmacyRatings>();
			
		for (PharmacyRatingsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("ratingId", dto.getRatingId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la pharmacyRatings existe
			PharmacyRatings entityToSave = null;
			entityToSave = pharmacyRatingsRepository.findOne(dto.getRatingId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("pharmacyRatings ratingId -> " + dto.getRatingId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if clients exist
			if (dto.getClientId() != null && dto.getClientId() > 0){
				Clients existingClients = clientsRepository.findOne(dto.getClientId(), false);
				if (existingClients == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("clients clientId -> " + dto.getClientId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setClients(existingClients);
			}
			// Verify if pharmacies exist
			if (dto.getPharmacyId() != null && dto.getPharmacyId() > 0){
				Pharmacies existingPharmacies = pharmaciesRepository.findOne(dto.getPharmacyId(), false);
				if (existingPharmacies == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("pharmacies pharmacyId -> " + dto.getPharmacyId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setPharmacies(existingPharmacies);
			}
			if (dto.getRatingValue() != null && dto.getRatingValue() > 0) {
				entityToSave.setRatingValue(dto.getRatingValue());
			}
			if (Utilities.notBlank(dto.getComment())) {
				entityToSave.setComment(dto.getComment());
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
			List<PharmacyRatings> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = pharmacyRatingsRepository.saveAll((Iterable<PharmacyRatings>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("pharmacyRatings", locale));
				response.setHasError(true);
				return response;
			}
			List<PharmacyRatingsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmacyRatingsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PharmacyRatingsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update PharmacyRatings-----");
		return response;
	}

	/**
	 * delete PharmacyRatings by using PharmacyRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacyRatingsDto> delete(Request<PharmacyRatingsDto> request, Locale locale)  {
		log.info("----begin delete PharmacyRatings-----");

		Response<PharmacyRatingsDto> response = new Response<PharmacyRatingsDto>();
		List<PharmacyRatings>        items    = new ArrayList<PharmacyRatings>();
			
		for (PharmacyRatingsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("ratingId", dto.getRatingId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la pharmacyRatings existe
			PharmacyRatings existingEntity = null;
			existingEntity = pharmacyRatingsRepository.findOne(dto.getRatingId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("pharmacyRatings -> " + dto.getRatingId(), locale));
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
			pharmacyRatingsRepository.saveAll((Iterable<PharmacyRatings>) items);

			response.setHasError(false);
		}

		log.info("----end delete PharmacyRatings-----");
		return response;
	}

	/**
	 * get PharmacyRatings by using PharmacyRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmacyRatingsDto> getByCriteria(Request<PharmacyRatingsDto> request, Locale locale)  throws Exception {
		log.info("----begin get PharmacyRatings-----");

		Response<PharmacyRatingsDto> response = new Response<PharmacyRatingsDto>();
		List<PharmacyRatings> items 			 = pharmacyRatingsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PharmacyRatingsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmacyRatingsTransformer.INSTANCE.toLiteDtos(items) : PharmacyRatingsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(pharmacyRatingsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("pharmacyRatings", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get PharmacyRatings-----");
		return response;
	}

	/**
	 * get full PharmacyRatingsDto by using PharmacyRatings as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PharmacyRatingsDto getFullInfos(PharmacyRatingsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
