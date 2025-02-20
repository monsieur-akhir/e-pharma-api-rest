                                                                                																		
/*
 * Java business for entity table pharmacies 
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
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "pharmacies"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class PharmaciesBusiness implements IBasicBusiness<Request<PharmaciesDto>, Response<PharmaciesDto>> {

	private Response<PharmaciesDto> response;
	@Autowired
	private PharmaciesRepository pharmaciesRepository;
	@Autowired
	private DeliveriesRepository deliveriesRepository;
	@Autowired
	private PharmacyRatingsRepository pharmacyRatingsRepository;
	@Autowired
	private PurchaseOrdersRepository purchaseOrdersRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private StockAlertsRepository stockAlertsRepository;
	@Autowired
	private StockRepository stockRepository;
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

	public PharmaciesBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Pharmacies by using PharmaciesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmaciesDto> create(Request<PharmaciesDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Pharmacies-----");

		Response<PharmaciesDto> response = new Response<PharmaciesDto>();
		List<Pharmacies>        items    = new ArrayList<Pharmacies>();
			
		for (PharmaciesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyName", dto.getPharmacyName());
			fieldsToVerify.put("address", dto.getAddress());
			fieldsToVerify.put("city", dto.getCity());
			fieldsToVerify.put("country", dto.getCountry());
			fieldsToVerify.put("phone", dto.getPhone());
			fieldsToVerify.put("location", dto.getLocation());
			fieldsToVerify.put("logo", dto.getLogo());
			fieldsToVerify.put("autorisation", dto.getAutorisation());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if pharmacies to insert do not exist
			Pharmacies existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("pharmacies pharmacyId -> " + dto.getPharmacyId(), locale));
				response.setHasError(true);
				return response;
			}

				Pharmacies entityToSave = null;
			entityToSave = PharmaciesTransformer.INSTANCE.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Pharmacies> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = pharmaciesRepository.saveAll((Iterable<Pharmacies>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("pharmacies", locale));
				response.setHasError(true);
				return response;
			}
			List<PharmaciesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmaciesTransformer.INSTANCE.toLiteDtos(itemsSaved) : PharmaciesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Pharmacies-----");
		return response;
	}

	/**
	 * update Pharmacies by using PharmaciesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmaciesDto> update(Request<PharmaciesDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Pharmacies-----");

		Response<PharmaciesDto> response = new Response<PharmaciesDto>();
		List<Pharmacies>        items    = new ArrayList<Pharmacies>();
			
		for (PharmaciesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la pharmacies existe
			Pharmacies entityToSave = null;
			entityToSave = pharmaciesRepository.findOne(dto.getPharmacyId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("pharmacies pharmacyId -> " + dto.getPharmacyId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getPharmacyName())) {
				entityToSave.setPharmacyName(dto.getPharmacyName());
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
			if (Utilities.notBlank(dto.getPhone())) {
				entityToSave.setPhone(dto.getPhone());
			}
			if (dto.getLocation() != null) {
				entityToSave.setLocation(dto.getLocation());
			}
			if (Utilities.notBlank(dto.getLogo())) {
				entityToSave.setLogo(dto.getLogo());
			}
			if (Utilities.notBlank(dto.getAutorisation())) {
				entityToSave.setAutorisation(dto.getAutorisation());
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
			List<Pharmacies> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = pharmaciesRepository.saveAll((Iterable<Pharmacies>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("pharmacies", locale));
				response.setHasError(true);
				return response;
			}
			List<PharmaciesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmaciesTransformer.INSTANCE.toLiteDtos(itemsSaved) : PharmaciesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Pharmacies-----");
		return response;
	}

	/**
	 * delete Pharmacies by using PharmaciesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmaciesDto> delete(Request<PharmaciesDto> request, Locale locale)  {
		log.info("----begin delete Pharmacies-----");

		Response<PharmaciesDto> response = new Response<PharmaciesDto>();
		List<Pharmacies>        items    = new ArrayList<Pharmacies>();
			
		for (PharmaciesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la pharmacies existe
			Pharmacies existingEntity = null;
			existingEntity = pharmaciesRepository.findOne(dto.getPharmacyId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("pharmacies -> " + dto.getPharmacyId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// deliveries
			List<Deliveries> listOfDeliveries = deliveriesRepository.findByPharmacyId(existingEntity.getPharmacyId(), false);
			if (listOfDeliveries != null && !listOfDeliveries.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfDeliveries.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// pharmacyRatings
			List<PharmacyRatings> listOfPharmacyRatings = pharmacyRatingsRepository.findByPharmacyId(existingEntity.getPharmacyId(), false);
			if (listOfPharmacyRatings != null && !listOfPharmacyRatings.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPharmacyRatings.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// purchaseOrders
			List<PurchaseOrders> listOfPurchaseOrders = purchaseOrdersRepository.findByPharmacyId(existingEntity.getPharmacyId(), false);
			if (listOfPurchaseOrders != null && !listOfPurchaseOrders.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPurchaseOrders.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// users
			List<Users> listOfUsers = usersRepository.findByPharmacyId(existingEntity.getPharmacyId(), false);
			if (listOfUsers != null && !listOfUsers.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUsers.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// stockAlerts
			List<StockAlerts> listOfStockAlerts = stockAlertsRepository.findByPharmacyId(existingEntity.getPharmacyId(), false);
			if (listOfStockAlerts != null && !listOfStockAlerts.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfStockAlerts.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// stock
			List<Stock> listOfStock = stockRepository.findByPharmacyId(existingEntity.getPharmacyId(), false);
			if (listOfStock != null && !listOfStock.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfStock.size() + ")", locale));
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
			pharmaciesRepository.saveAll((Iterable<Pharmacies>) items);

			response.setHasError(false);
		}

		log.info("----end delete Pharmacies-----");
		return response;
	}

	/**
	 * get Pharmacies by using PharmaciesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PharmaciesDto> getByCriteria(Request<PharmaciesDto> request, Locale locale)  throws Exception {
		log.info("----begin get Pharmacies-----");

		Response<PharmaciesDto> response = new Response<PharmaciesDto>();
		List<Pharmacies> items 			 = pharmaciesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PharmaciesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PharmaciesTransformer.INSTANCE.toLiteDtos(items) : PharmaciesTransformer.INSTANCE.toDtos(items);

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
			response.setCount(pharmaciesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("pharmacies", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Pharmacies-----");
		return response;
	}

	/**
	 * get full PharmaciesDto by using Pharmacies as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PharmaciesDto getFullInfos(PharmaciesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
