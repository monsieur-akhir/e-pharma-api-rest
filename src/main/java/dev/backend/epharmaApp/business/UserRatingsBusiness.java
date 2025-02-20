                                                                														
/*
 * Java business for entity table user_ratings 
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
import dev.backend.epharmaApp.dao.entity.UserRatings;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "user_ratings"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class UserRatingsBusiness implements IBasicBusiness<Request<UserRatingsDto>, Response<UserRatingsDto>> {

	private Response<UserRatingsDto> response;
	@Autowired
	private UserRatingsRepository userRatingsRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UsersRepository users2Repository;
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

	public UserRatingsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create UserRatings by using UserRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRatingsDto> create(Request<UserRatingsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create UserRatings-----");

		Response<UserRatingsDto> response = new Response<UserRatingsDto>();
		List<UserRatings>        items    = new ArrayList<UserRatings>();
			
		for (UserRatingsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("ratedUserId", dto.getRatedUserId());
			fieldsToVerify.put("raterId", dto.getRaterId());
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

			// Verify if userRatings to insert do not exist
			UserRatings existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("userRatings ratingId -> " + dto.getRatingId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if users exist
			Users existingUsers = null;
			if (dto.getRatedUserId() != null && dto.getRatedUserId() > 0){
				existingUsers = usersRepository.findOne(dto.getRatedUserId(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users ratedUserId -> " + dto.getRatedUserId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if users2 exist
			Users existingUsers2 = null;
			if (dto.getRaterId() != null && dto.getRaterId() > 0){
				existingUsers2 = users2Repository.findOne(dto.getRaterId(), false);
				if (existingUsers2 == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users2 raterId -> " + dto.getRaterId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				UserRatings entityToSave = null;
			entityToSave = UserRatingsTransformer.INSTANCE.toEntity(dto, existingUsers, existingUsers2);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UserRatings> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = userRatingsRepository.saveAll((Iterable<UserRatings>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userRatings", locale));
				response.setHasError(true);
				return response;
			}
			List<UserRatingsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserRatingsTransformer.INSTANCE.toLiteDtos(itemsSaved) : UserRatingsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create UserRatings-----");
		return response;
	}

	/**
	 * update UserRatings by using UserRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRatingsDto> update(Request<UserRatingsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update UserRatings-----");

		Response<UserRatingsDto> response = new Response<UserRatingsDto>();
		List<UserRatings>        items    = new ArrayList<UserRatings>();
			
		for (UserRatingsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("ratingId", dto.getRatingId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userRatings existe
			UserRatings entityToSave = null;
			entityToSave = userRatingsRepository.findOne(dto.getRatingId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userRatings ratingId -> " + dto.getRatingId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if users exist
			if (dto.getRatedUserId() != null && dto.getRatedUserId() > 0){
				Users existingUsers = usersRepository.findOne(dto.getRatedUserId(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users ratedUserId -> " + dto.getRatedUserId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setUsers(existingUsers);
			}
			// Verify if users2 exist
			if (dto.getRaterId() != null && dto.getRaterId() > 0){
				Users existingUsers2 = users2Repository.findOne(dto.getRaterId(), false);
				if (existingUsers2 == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users2 raterId -> " + dto.getRaterId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setUsers2(existingUsers2);
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
			List<UserRatings> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = userRatingsRepository.saveAll((Iterable<UserRatings>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("userRatings", locale));
				response.setHasError(true);
				return response;
			}
			List<UserRatingsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserRatingsTransformer.INSTANCE.toLiteDtos(itemsSaved) : UserRatingsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update UserRatings-----");
		return response;
	}

	/**
	 * delete UserRatings by using UserRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRatingsDto> delete(Request<UserRatingsDto> request, Locale locale)  {
		log.info("----begin delete UserRatings-----");

		Response<UserRatingsDto> response = new Response<UserRatingsDto>();
		List<UserRatings>        items    = new ArrayList<UserRatings>();
			
		for (UserRatingsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("ratingId", dto.getRatingId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la userRatings existe
			UserRatings existingEntity = null;
			existingEntity = userRatingsRepository.findOne(dto.getRatingId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("userRatings -> " + dto.getRatingId(), locale));
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
			userRatingsRepository.saveAll((Iterable<UserRatings>) items);

			response.setHasError(false);
		}

		log.info("----end delete UserRatings-----");
		return response;
	}

	/**
	 * get UserRatings by using UserRatingsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UserRatingsDto> getByCriteria(Request<UserRatingsDto> request, Locale locale)  throws Exception {
		log.info("----begin get UserRatings-----");

		Response<UserRatingsDto> response = new Response<UserRatingsDto>();
		List<UserRatings> items 			 = userRatingsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UserRatingsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UserRatingsTransformer.INSTANCE.toLiteDtos(items) : UserRatingsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(userRatingsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("userRatings", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get UserRatings-----");
		return response;
	}

	/**
	 * get full UserRatingsDto by using UserRatings as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private UserRatingsDto getFullInfos(UserRatingsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
