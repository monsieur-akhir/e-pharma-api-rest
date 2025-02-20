                                                                    															
/*
 * Java business for entity table purchase_orders 
 * Created on 2025-02-15 ( Time 03:02:46 )
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
import dev.backend.epharmaApp.dao.entity.PurchaseOrders;
import dev.backend.epharmaApp.dao.entity.Manufacturers;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "purchase_orders"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class PurchaseOrdersBusiness implements IBasicBusiness<Request<PurchaseOrdersDto>, Response<PurchaseOrdersDto>> {

	private Response<PurchaseOrdersDto> response;
	@Autowired
	private PurchaseOrdersRepository purchaseOrdersRepository;
	@Autowired
	private PurchaseOrderItemsRepository purchaseOrderItemsRepository;
	@Autowired
	private ManufacturersRepository manufacturersRepository;
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

	public PurchaseOrdersBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create PurchaseOrders by using PurchaseOrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrdersDto> create(Request<PurchaseOrdersDto> request, Locale locale)  throws ParseException {
		log.info("----begin create PurchaseOrders-----");

		Response<PurchaseOrdersDto> response = new Response<PurchaseOrdersDto>();
		List<PurchaseOrders>        items    = new ArrayList<PurchaseOrders>();
			
		for (PurchaseOrdersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			fieldsToVerify.put("manufacturerId", dto.getManufacturerId());
			fieldsToVerify.put("orderDate", dto.getOrderDate());
			fieldsToVerify.put("status", dto.getStatus());
//			fieldsToVerify.put("totalAmount", dto.getTotalAmount());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if purchaseOrders to insert do not exist
			PurchaseOrders existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("purchaseOrders poId -> " + dto.getPoId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if manufacturers exist
			Manufacturers existingManufacturers = null;
			if (dto.getManufacturerId() != null && dto.getManufacturerId() > 0){
				existingManufacturers = manufacturersRepository.findOne(dto.getManufacturerId(), false);
				if (existingManufacturers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("manufacturers manufacturerId -> " + dto.getManufacturerId(), locale));
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
				PurchaseOrders entityToSave = null;
			entityToSave = PurchaseOrdersTransformer.INSTANCE.toEntity(dto, existingManufacturers, existingPharmacies);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PurchaseOrders> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = purchaseOrdersRepository.saveAll((Iterable<PurchaseOrders>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("purchaseOrders", locale));
				response.setHasError(true);
				return response;
			}
			List<PurchaseOrdersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PurchaseOrdersTransformer.INSTANCE.toLiteDtos(itemsSaved) : PurchaseOrdersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create PurchaseOrders-----");
		return response;
	}

	/**
	 * update PurchaseOrders by using PurchaseOrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrdersDto> update(Request<PurchaseOrdersDto> request, Locale locale)  throws ParseException {
		log.info("----begin update PurchaseOrders-----");

		Response<PurchaseOrdersDto> response = new Response<PurchaseOrdersDto>();
		List<PurchaseOrders>        items    = new ArrayList<PurchaseOrders>();
			
		for (PurchaseOrdersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("poId", dto.getPoId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la purchaseOrders existe
			PurchaseOrders entityToSave = null;
			entityToSave = purchaseOrdersRepository.findOne(dto.getPoId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("purchaseOrders poId -> " + dto.getPoId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if manufacturers exist
			if (dto.getManufacturerId() != null && dto.getManufacturerId() > 0){
				Manufacturers existingManufacturers = manufacturersRepository.findOne(dto.getManufacturerId(), false);
				if (existingManufacturers == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("manufacturers manufacturerId -> " + dto.getManufacturerId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setManufacturers(existingManufacturers);
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
			if (Utilities.notBlank(dto.getOrderDate())) {
				entityToSave.setOrderDate(dateFormat.parse(dto.getOrderDate()));
			}
			if (Utilities.notBlank(dto.getStatus())) {
				entityToSave.setStatus(dto.getStatus());
			}
			if (dto.getTotalAmount() != null && dto.getTotalAmount() > 0) {
				entityToSave.setTotalAmount(dto.getTotalAmount());
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
			List<PurchaseOrders> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = purchaseOrdersRepository.saveAll((Iterable<PurchaseOrders>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("purchaseOrders", locale));
				response.setHasError(true);
				return response;
			}
			List<PurchaseOrdersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PurchaseOrdersTransformer.INSTANCE.toLiteDtos(itemsSaved) : PurchaseOrdersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update PurchaseOrders-----");
		return response;
	}

	/**
	 * delete PurchaseOrders by using PurchaseOrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrdersDto> delete(Request<PurchaseOrdersDto> request, Locale locale)  {
		log.info("----begin delete PurchaseOrders-----");

		Response<PurchaseOrdersDto> response = new Response<PurchaseOrdersDto>();
		List<PurchaseOrders>        items    = new ArrayList<PurchaseOrders>();
			
		for (PurchaseOrdersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("poId", dto.getPoId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la purchaseOrders existe
			PurchaseOrders existingEntity = null;
			existingEntity = purchaseOrdersRepository.findOne(dto.getPoId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("purchaseOrders -> " + dto.getPoId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// purchaseOrderItems
			List<PurchaseOrderItems> listOfPurchaseOrderItems = purchaseOrderItemsRepository.findByPoId(existingEntity.getPoId(), false);
			if (listOfPurchaseOrderItems != null && !listOfPurchaseOrderItems.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPurchaseOrderItems.size() + ")", locale));
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
			purchaseOrdersRepository.saveAll((Iterable<PurchaseOrders>) items);

			response.setHasError(false);
		}

		log.info("----end delete PurchaseOrders-----");
		return response;
	}

	/**
	 * get PurchaseOrders by using PurchaseOrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrdersDto> getByCriteria(Request<PurchaseOrdersDto> request, Locale locale)  throws Exception {
		log.info("----begin get PurchaseOrders-----");

		Response<PurchaseOrdersDto> response = new Response<PurchaseOrdersDto>();
		List<PurchaseOrders> items 			 = purchaseOrdersRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PurchaseOrdersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PurchaseOrdersTransformer.INSTANCE.toLiteDtos(items) : PurchaseOrdersTransformer.INSTANCE.toDtos(items);

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
			response.setCount(purchaseOrdersRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("purchaseOrders", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get PurchaseOrders-----");
		return response;
	}

	/**
	 * get full PurchaseOrdersDto by using PurchaseOrders as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PurchaseOrdersDto getFullInfos(PurchaseOrdersDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
