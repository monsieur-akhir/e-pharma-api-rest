                                                                                        																				
/*
 * Java business for entity table users 
 * Created on 2025-02-15 ( Time 03:02:48 )
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
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "users"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class UsersBusiness implements IBasicBusiness<Request<UsersDto>, Response<UsersDto>> {

	private Response<UsersDto> response;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ChatMessagesRepository chatMessagesRepository;
	@Autowired
	private DeliveryPersonProfilesRepository deliveryPersonProfilesRepository;
	@Autowired
	private DeliveriesRepository deliveriesRepository;
	@Autowired
	private UserRatingsRepository userRatingsRepository;
	@Autowired
	private ChatRoomParticipantsRepository chatRoomParticipantsRepository;
	@Autowired
	private UserRolesRepository userRolesRepository;
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

	public UsersBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> create(Request<UsersDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users>        items    = new ArrayList<Users>();
			
		for (UsersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("login", dto.getLogin());
			fieldsToVerify.put("email", dto.getEmail());
			fieldsToVerify.put("firstName", dto.getFirstName());
			fieldsToVerify.put("lastName", dto.getLastName());
			fieldsToVerify.put("passwordHash", dto.getPasswordHash());
			fieldsToVerify.put("phone", dto.getPhone());
			fieldsToVerify.put("address", dto.getAddress());
			fieldsToVerify.put("city", dto.getCity());
			fieldsToVerify.put("country", dto.getCountry());
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if users to insert do not exist
			Users existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("users userId -> " + dto.getUserId(), locale));
				response.setHasError(true);
				return response;
			}

			// verif unique login in db
			existingEntity = usersRepository.findByLogin(dto.getLogin(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("users login -> " + dto.getLogin(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique login in items to save
			if (items.stream().anyMatch(a -> a.getLogin().equalsIgnoreCase(dto.getLogin()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" login ", locale));
				response.setHasError(true);
				return response;
			}

			// verif unique email in db
			existingEntity = usersRepository.findByEmail(dto.getEmail(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("users email -> " + dto.getEmail(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getEmail().equalsIgnoreCase(dto.getEmail()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" email ", locale));
				response.setHasError(true);
				return response;
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
				Users entityToSave = null;
			entityToSave = UsersTransformer.INSTANCE.toEntity(dto, existingPharmacies);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Users> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = usersRepository.saveAll((Iterable<Users>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("users", locale));
				response.setHasError(true);
				return response;
			}
			List<UsersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UsersTransformer.INSTANCE.toLiteDtos(itemsSaved) : UsersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Users-----");
		return response;
	}

	/**
	 * update Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> update(Request<UsersDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users>        items    = new ArrayList<Users>();
			
		for (UsersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la users existe
			Users entityToSave = null;
			entityToSave = usersRepository.findOne(dto.getUserId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("users userId -> " + dto.getUserId(), locale));
				response.setHasError(true);
				return response;
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
			if (Utilities.notBlank(dto.getLogin())) {
				entityToSave.setLogin(dto.getLogin());
			}
			if (Utilities.notBlank(dto.getEmail())) {
				entityToSave.setEmail(dto.getEmail());
			}
			if (Utilities.notBlank(dto.getFirstName())) {
				entityToSave.setFirstName(dto.getFirstName());
			}
			if (Utilities.notBlank(dto.getLastName())) {
				entityToSave.setLastName(dto.getLastName());
			}
			if (Utilities.notBlank(dto.getPasswordHash())) {
				entityToSave.setPasswordHash(dto.getPasswordHash());
			}
			if (Utilities.notBlank(dto.getPhone())) {
				entityToSave.setPhone(dto.getPhone());
			}
			if (Utilities.notBlank(dto.getAddress())) {
				entityToSave.setAddress(dto.getAddress());
			}
			if (Utilities.notBlank(dto.getCity())) {
				entityToSave.setCity(dto.getCity());
			}
			if (Utilities.notBlank(dto.getCountry())) {
				entityToSave.setCountry(dto.getCountry());
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
			List<Users> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = usersRepository.saveAll((Iterable<Users>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("users", locale));
				response.setHasError(true);
				return response;
			}
			List<UsersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UsersTransformer.INSTANCE.toLiteDtos(itemsSaved) : UsersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Users-----");
		return response;
	}

	/**
	 * delete Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> delete(Request<UsersDto> request, Locale locale)  {
		log.info("----begin delete Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users>        items    = new ArrayList<Users>();
			
		for (UsersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("userId", dto.getUserId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la users existe
			Users existingEntity = null;
			existingEntity = usersRepository.findOne(dto.getUserId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("users -> " + dto.getUserId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// chatMessages
			List<ChatMessages> listOfChatMessages = chatMessagesRepository.findBySenderId(existingEntity.getUserId(), false);
			if (listOfChatMessages != null && !listOfChatMessages.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfChatMessages.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// deliveryPersonProfiles
			List<DeliveryPersonProfiles> listOfDeliveryPersonProfiles = deliveryPersonProfilesRepository.findByUserId(existingEntity.getUserId(), false);
			if (listOfDeliveryPersonProfiles != null && !listOfDeliveryPersonProfiles.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfDeliveryPersonProfiles.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// deliveries
			List<Deliveries> listOfDeliveries = deliveriesRepository.findByAssignedTo(existingEntity.getUserId(), false);
			if (listOfDeliveries != null && !listOfDeliveries.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfDeliveries.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// userRatings
			List<UserRatings> listOfUserRatings2 = userRatingsRepository.findByRaterId(existingEntity.getUserId(), false);
			if (listOfUserRatings2 != null && !listOfUserRatings2.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserRatings2.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// userRatings
			List<UserRatings> listOfUserRatings = userRatingsRepository.findByRaterId(existingEntity.getUserId(), false);
			if (listOfUserRatings != null && !listOfUserRatings.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserRatings.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// chatRoomParticipants
			List<ChatRoomParticipants> listOfChatRoomParticipants = chatRoomParticipantsRepository.findByUserId(existingEntity.getUserId(), false);
			if (listOfChatRoomParticipants != null && !listOfChatRoomParticipants.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfChatRoomParticipants.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// userRoles
			List<UserRoles> listOfUserRoles = userRolesRepository.findByUserId(existingEntity.getUserId(), false);
			if (listOfUserRoles != null && !listOfUserRoles.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUserRoles.size() + ")", locale));
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
			usersRepository.saveAll((Iterable<Users>) items);

			response.setHasError(false);
		}

		log.info("----end delete Users-----");
		return response;
	}

	/**
	 * get Users by using UsersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UsersDto> getByCriteria(Request<UsersDto> request, Locale locale)  throws Exception {
		log.info("----begin get Users-----");

		Response<UsersDto> response = new Response<UsersDto>();
		List<Users> items 			 = usersRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UsersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UsersTransformer.INSTANCE.toLiteDtos(items) : UsersTransformer.INSTANCE.toDtos(items);

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
			response.setCount(usersRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("users", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Users-----");
		return response;
	}

	/**
	 * get full UsersDto by using Users as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private UsersDto getFullInfos(UsersDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
