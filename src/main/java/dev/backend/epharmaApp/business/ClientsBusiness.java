                                                                                        																				
/*
 * Java business for entity table clients 
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
import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "clients"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ClientsBusiness implements IBasicBusiness<Request<ClientsDto>, Response<ClientsDto>> {

	private Response<ClientsDto> response;
	@Autowired
	private ClientsRepository clientsRepository;
	@Autowired
	private PharmacyRatingsRepository pharmacyRatingsRepository;
	@Autowired
	private ClientRolesRepository clientRolesRepository;
	@Autowired
	private OrdersRepository ordersRepository;
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

	public ClientsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Clients by using ClientsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientsDto> create(Request<ClientsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Clients-----");

		Response<ClientsDto> response = new Response<ClientsDto>();
		List<Clients>        items    = new ArrayList<Clients>();
			
		for (ClientsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("loginClient", dto.getLoginClient());
			fieldsToVerify.put("firstName", dto.getFirstName());
			fieldsToVerify.put("lastName", dto.getLastName());
			fieldsToVerify.put("email", dto.getEmail());
			fieldsToVerify.put("phone", dto.getPhone());
			fieldsToVerify.put("address", dto.getAddress());
			fieldsToVerify.put("city", dto.getCity());
			fieldsToVerify.put("location", dto.getLocation());
			fieldsToVerify.put("birthday", dto.getBirthday());
			fieldsToVerify.put("photo", dto.getPhoto());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if clients to insert do not exist
			Clients existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("clients clientId -> " + dto.getClientId(), locale));
				response.setHasError(true);
				return response;
			}

			// verif unique email in db
			existingEntity = clientsRepository.findByEmail(dto.getEmail(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("clients email -> " + dto.getEmail(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getEmail().equalsIgnoreCase(dto.getEmail()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" email ", locale));
				response.setHasError(true);
				return response;
			}

				Clients entityToSave = null;
			entityToSave = ClientsTransformer.INSTANCE.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Clients> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = clientsRepository.saveAll((Iterable<Clients>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("clients", locale));
				response.setHasError(true);
				return response;
			}
			List<ClientsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ClientsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ClientsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Clients-----");
		return response;
	}

	/**
	 * update Clients by using ClientsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientsDto> update(Request<ClientsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Clients-----");

		Response<ClientsDto> response = new Response<ClientsDto>();
		List<Clients>        items    = new ArrayList<Clients>();
			
		for (ClientsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("clientId", dto.getClientId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la clients existe
			Clients entityToSave = null;
			entityToSave = clientsRepository.findOne(dto.getClientId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("clients clientId -> " + dto.getClientId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getLoginClient())) {
				entityToSave.setLoginClient(dto.getLoginClient());
			}
			if (Utilities.notBlank(dto.getFirstName())) {
				entityToSave.setFirstName(dto.getFirstName());
			}
			if (Utilities.notBlank(dto.getLastName())) {
				entityToSave.setLastName(dto.getLastName());
			}
			if (Utilities.notBlank(dto.getEmail())) {
				entityToSave.setEmail(dto.getEmail());
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
			if (dto.getLocation() != null) {
				entityToSave.setLocation(dto.getLocation());
			}
			if (Utilities.notBlank(dto.getBirthday())) {
				entityToSave.setBirthday(dateFormat.parse(dto.getBirthday()));
			}
			if (Utilities.notBlank(dto.getPhoto())) {
				entityToSave.setPhoto(dto.getPhoto());
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
			List<Clients> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = clientsRepository.saveAll((Iterable<Clients>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("clients", locale));
				response.setHasError(true);
				return response;
			}
			List<ClientsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ClientsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ClientsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Clients-----");
		return response;
	}

	/**
	 * delete Clients by using ClientsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientsDto> delete(Request<ClientsDto> request, Locale locale)  {
		log.info("----begin delete Clients-----");

		Response<ClientsDto> response = new Response<ClientsDto>();
		List<Clients>        items    = new ArrayList<Clients>();
			
		for (ClientsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("clientId", dto.getClientId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la clients existe
			Clients existingEntity = null;
			existingEntity = clientsRepository.findOne(dto.getClientId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("clients -> " + dto.getClientId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// pharmacyRatings
			List<PharmacyRatings> listOfPharmacyRatings = pharmacyRatingsRepository.findByClientId(existingEntity.getClientId(), false);
			if (listOfPharmacyRatings != null && !listOfPharmacyRatings.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPharmacyRatings.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// clientRoles
			List<ClientRoles> listOfClientRoles = clientRolesRepository.findByClientId(existingEntity.getClientId(), false);
			if (listOfClientRoles != null && !listOfClientRoles.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfClientRoles.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// orders
			List<Orders> listOfOrders = ordersRepository.findByClientId(existingEntity.getClientId(), false);
			if (listOfOrders != null && !listOfOrders.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfOrders.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// prescriptions
			List<Prescriptions> listOfPrescriptions = prescriptionsRepository.findByClientId(existingEntity.getClientId(), false);
			if (listOfPrescriptions != null && !listOfPrescriptions.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrescriptions.size() + ")", locale));
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
			clientsRepository.saveAll((Iterable<Clients>) items);

			response.setHasError(false);
		}

		log.info("----end delete Clients-----");
		return response;
	}

	/**
	 * get Clients by using ClientsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientsDto> getByCriteria(Request<ClientsDto> request, Locale locale)  throws Exception {
		log.info("----begin get Clients-----");

		Response<ClientsDto> response = new Response<ClientsDto>();
		List<Clients> items 			 = clientsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ClientsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ClientsTransformer.INSTANCE.toLiteDtos(items) : ClientsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(clientsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("clients", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Clients-----");
		return response;
	}

	/**
	 * get full ClientsDto by using Clients as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ClientsDto getFullInfos(ClientsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
