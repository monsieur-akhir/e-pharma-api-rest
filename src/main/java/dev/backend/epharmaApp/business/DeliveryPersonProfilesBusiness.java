                                                        												
/*
 * Java business for entity table delivery_person_profiles 
 * Created on 2025-02-15 ( Time 03:02:41 )
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
import dev.backend.epharmaApp.dao.entity.DeliveryPersonProfiles;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "delivery_person_profiles"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class DeliveryPersonProfilesBusiness implements IBasicBusiness<Request<DeliveryPersonProfilesDto>, Response<DeliveryPersonProfilesDto>> {

	private Response<DeliveryPersonProfilesDto> response;
	@Autowired
	private DeliveryPersonProfilesRepository deliveryPersonProfilesRepository;
	@Autowired
	private UsersRepository usersRepository;
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

	public DeliveryPersonProfilesBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create DeliveryPersonProfiles by using DeliveryPersonProfilesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveryPersonProfilesDto> create(Request<DeliveryPersonProfilesDto> request, Locale locale)  throws ParseException {
		log.info("----begin create DeliveryPersonProfiles-----");

		Response<DeliveryPersonProfilesDto> response = new Response<DeliveryPersonProfilesDto>();
		List<DeliveryPersonProfiles>        items    = new ArrayList<DeliveryPersonProfiles>();
			
		for (DeliveryPersonProfilesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("status", dto.getStatus());
			fieldsToVerify.put("registeredDate", dto.getRegisteredDate());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if deliveryPersonProfiles to insert do not exist
			DeliveryPersonProfiles existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("deliveryPersonProfiles userId -> " + dto.getUserId(), locale));
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
				DeliveryPersonProfiles entityToSave = null;
			entityToSave = DeliveryPersonProfilesTransformer.INSTANCE.toEntity(dto, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<DeliveryPersonProfiles> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = deliveryPersonProfilesRepository.saveAll((Iterable<DeliveryPersonProfiles>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("deliveryPersonProfiles", locale));
				response.setHasError(true);
				return response;
			}
			List<DeliveryPersonProfilesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? DeliveryPersonProfilesTransformer.INSTANCE.toLiteDtos(itemsSaved) : DeliveryPersonProfilesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create DeliveryPersonProfiles-----");
		return response;
	}

	/**
	 * update DeliveryPersonProfiles by using DeliveryPersonProfilesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveryPersonProfilesDto> update(Request<DeliveryPersonProfilesDto> request, Locale locale)  throws ParseException {
		log.info("----begin update DeliveryPersonProfiles-----");

		Response<DeliveryPersonProfilesDto> response = new Response<DeliveryPersonProfilesDto>();
		List<DeliveryPersonProfiles>        items    = new ArrayList<DeliveryPersonProfiles>();
			
		for (DeliveryPersonProfilesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la deliveryPersonProfiles existe
			DeliveryPersonProfiles entityToSave = null;
			entityToSave = deliveryPersonProfilesRepository.findOne(dto.getUserId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("deliveryPersonProfiles userId -> " + dto.getUserId(), locale));
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
			if (Utilities.notBlank(dto.getStatus())) {
				entityToSave.setStatus(dto.getStatus());
			}
			if (Utilities.notBlank(dto.getRegisteredDate())) {
				entityToSave.setRegisteredDate(dateFormat.parse(dto.getRegisteredDate()));
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
			List<DeliveryPersonProfiles> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = deliveryPersonProfilesRepository.saveAll((Iterable<DeliveryPersonProfiles>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("deliveryPersonProfiles", locale));
				response.setHasError(true);
				return response;
			}
			List<DeliveryPersonProfilesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? DeliveryPersonProfilesTransformer.INSTANCE.toLiteDtos(itemsSaved) : DeliveryPersonProfilesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update DeliveryPersonProfiles-----");
		return response;
	}

	/**
	 * delete DeliveryPersonProfiles by using DeliveryPersonProfilesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveryPersonProfilesDto> delete(Request<DeliveryPersonProfilesDto> request, Locale locale)  {
		log.info("----begin delete DeliveryPersonProfiles-----");

		Response<DeliveryPersonProfilesDto> response = new Response<DeliveryPersonProfilesDto>();
		List<DeliveryPersonProfiles>        items    = new ArrayList<DeliveryPersonProfiles>();
			
		for (DeliveryPersonProfilesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la deliveryPersonProfiles existe
			DeliveryPersonProfiles existingEntity = null;
			existingEntity = deliveryPersonProfilesRepository.findOne(dto.getUserId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("deliveryPersonProfiles -> " + dto.getUserId(), locale));
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
			deliveryPersonProfilesRepository.saveAll((Iterable<DeliveryPersonProfiles>) items);

			response.setHasError(false);
		}

		log.info("----end delete DeliveryPersonProfiles-----");
		return response;
	}

	/**
	 * get DeliveryPersonProfiles by using DeliveryPersonProfilesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveryPersonProfilesDto> getByCriteria(Request<DeliveryPersonProfilesDto> request, Locale locale)  throws Exception {
		log.info("----begin get DeliveryPersonProfiles-----");

		Response<DeliveryPersonProfilesDto> response = new Response<DeliveryPersonProfilesDto>();
		List<DeliveryPersonProfiles> items 			 = deliveryPersonProfilesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<DeliveryPersonProfilesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? DeliveryPersonProfilesTransformer.INSTANCE.toLiteDtos(items) : DeliveryPersonProfilesTransformer.INSTANCE.toDtos(items);

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
			response.setCount(deliveryPersonProfilesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("deliveryPersonProfiles", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get DeliveryPersonProfiles-----");
		return response;
	}

	/**
	 * get full DeliveryPersonProfilesDto by using DeliveryPersonProfiles as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private DeliveryPersonProfilesDto getFullInfos(DeliveryPersonProfilesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
