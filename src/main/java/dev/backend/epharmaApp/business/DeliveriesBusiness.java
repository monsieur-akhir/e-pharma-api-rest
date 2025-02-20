                                                                                																		
/*
 * Java business for entity table deliveries 
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
import dev.backend.epharmaApp.dao.entity.Deliveries;
import dev.backend.epharmaApp.dao.entity.Orders;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "deliveries"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class DeliveriesBusiness implements IBasicBusiness<Request<DeliveriesDto>, Response<DeliveriesDto>> {

	private Response<DeliveriesDto> response;
	@Autowired
	private DeliveriesRepository deliveriesRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private PharmaciesRepository pharmaciesRepository;
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

	public DeliveriesBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Deliveries by using DeliveriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveriesDto> create(Request<DeliveriesDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Deliveries-----");

		Response<DeliveriesDto> response = new Response<DeliveriesDto>();
		List<Deliveries>        items    = new ArrayList<Deliveries>();
			
		for (DeliveriesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("orderId", dto.getOrderId());
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			fieldsToVerify.put("assignedTo", dto.getAssignedTo());
			fieldsToVerify.put("deliveryStatus", dto.getDeliveryStatus());
			fieldsToVerify.put("expectedDeliveryDate", dto.getExpectedDeliveryDate());
			fieldsToVerify.put("actualDeliveryDate", dto.getActualDeliveryDate());
			fieldsToVerify.put("trackingNumber", dto.getTrackingNumber());
			fieldsToVerify.put("deliveryMethod", dto.getDeliveryMethod());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if deliveries to insert do not exist
			Deliveries existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("deliveries deliveryId -> " + dto.getDeliveryId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if orders exist
			Orders existingOrders = null;
			if (dto.getOrderId() != null && dto.getOrderId() > 0){
				existingOrders = ordersRepository.findOne(dto.getOrderId(), false);
				if (existingOrders == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("orders orderId -> " + dto.getOrderId(), locale));
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
			// Verify if users exist
			Users existingUsers = null;
			if (dto.getAssignedTo() != null && dto.getAssignedTo() > 0){
				existingUsers = usersRepository.findOne(dto.getAssignedTo(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users assignedTo -> " + dto.getAssignedTo(), locale));
					response.setHasError(true);
					return response;
				}
			}
				Deliveries entityToSave = null;
			entityToSave = DeliveriesTransformer.INSTANCE.toEntity(dto, existingOrders, existingPharmacies, existingUsers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Deliveries> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = deliveriesRepository.saveAll((Iterable<Deliveries>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("deliveries", locale));
				response.setHasError(true);
				return response;
			}
			List<DeliveriesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? DeliveriesTransformer.INSTANCE.toLiteDtos(itemsSaved) : DeliveriesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Deliveries-----");
		return response;
	}

	/**
	 * update Deliveries by using DeliveriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveriesDto> update(Request<DeliveriesDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Deliveries-----");

		Response<DeliveriesDto> response = new Response<DeliveriesDto>();
		List<Deliveries>        items    = new ArrayList<Deliveries>();
			
		for (DeliveriesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("deliveryId", dto.getDeliveryId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la deliveries existe
			Deliveries entityToSave = null;
			entityToSave = deliveriesRepository.findOne(dto.getDeliveryId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("deliveries deliveryId -> " + dto.getDeliveryId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if orders exist
			if (dto.getOrderId() != null && dto.getOrderId() > 0){
				Orders existingOrders = ordersRepository.findOne(dto.getOrderId(), false);
				if (existingOrders == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("orders orderId -> " + dto.getOrderId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setOrders(existingOrders);
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
			// Verify if users exist
			if (dto.getAssignedTo() != null && dto.getAssignedTo() > 0){
				Users existingUsers = usersRepository.findOne(dto.getAssignedTo(), false);
				if (existingUsers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("users assignedTo -> " + dto.getAssignedTo(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setUsers(existingUsers);
			}
			if (Utilities.notBlank(dto.getDeliveryStatus())) {
				entityToSave.setDeliveryStatus(dto.getDeliveryStatus());
			}
			if (Utilities.notBlank(dto.getExpectedDeliveryDate())) {
				entityToSave.setExpectedDeliveryDate(dateFormat.parse(dto.getExpectedDeliveryDate()));
			}
			if (Utilities.notBlank(dto.getActualDeliveryDate())) {
				entityToSave.setActualDeliveryDate(dateFormat.parse(dto.getActualDeliveryDate()));
			}
			if (Utilities.notBlank(dto.getTrackingNumber())) {
				entityToSave.setTrackingNumber(dto.getTrackingNumber());
			}
			if (Utilities.notBlank(dto.getDeliveryMethod())) {
				entityToSave.setDeliveryMethod(dto.getDeliveryMethod());
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
			List<Deliveries> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = deliveriesRepository.saveAll((Iterable<Deliveries>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("deliveries", locale));
				response.setHasError(true);
				return response;
			}
			List<DeliveriesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? DeliveriesTransformer.INSTANCE.toLiteDtos(itemsSaved) : DeliveriesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Deliveries-----");
		return response;
	}

	/**
	 * delete Deliveries by using DeliveriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveriesDto> delete(Request<DeliveriesDto> request, Locale locale)  {
		log.info("----begin delete Deliveries-----");

		Response<DeliveriesDto> response = new Response<DeliveriesDto>();
		List<Deliveries>        items    = new ArrayList<Deliveries>();
			
		for (DeliveriesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("deliveryId", dto.getDeliveryId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la deliveries existe
			Deliveries existingEntity = null;
			existingEntity = deliveriesRepository.findOne(dto.getDeliveryId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("deliveries -> " + dto.getDeliveryId(), locale));
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
			deliveriesRepository.saveAll((Iterable<Deliveries>) items);

			response.setHasError(false);
		}

		log.info("----end delete Deliveries-----");
		return response;
	}

	/**
	 * get Deliveries by using DeliveriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<DeliveriesDto> getByCriteria(Request<DeliveriesDto> request, Locale locale)  throws Exception {
		log.info("----begin get Deliveries-----");

		Response<DeliveriesDto> response = new Response<DeliveriesDto>();
		List<Deliveries> items 			 = deliveriesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<DeliveriesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? DeliveriesTransformer.INSTANCE.toLiteDtos(items) : DeliveriesTransformer.INSTANCE.toDtos(items);

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
			response.setCount(deliveriesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("deliveries", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Deliveries-----");
		return response;
	}

	/**
	 * get full DeliveriesDto by using Deliveries as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private DeliveriesDto getFullInfos(DeliveriesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
