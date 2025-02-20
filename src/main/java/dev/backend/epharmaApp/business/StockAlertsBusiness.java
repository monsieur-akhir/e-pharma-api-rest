                                                                        																
/*
 * Java business for entity table stock_alerts 
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
import dev.backend.epharmaApp.dao.entity.StockAlerts;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "stock_alerts"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class StockAlertsBusiness implements IBasicBusiness<Request<StockAlertsDto>, Response<StockAlertsDto>> {

	private Response<StockAlertsDto> response;
	@Autowired
	private StockAlertsRepository stockAlertsRepository;
	@Autowired
	private ProductsRepository productsRepository;
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

	public StockAlertsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create StockAlerts by using StockAlertsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAlertsDto> create(Request<StockAlertsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create StockAlerts-----");

		Response<StockAlertsDto> response = new Response<StockAlertsDto>();
		List<StockAlerts>        items    = new ArrayList<StockAlerts>();
			
		for (StockAlertsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			fieldsToVerify.put("productId", dto.getProductId());
			fieldsToVerify.put("currentQuantity", dto.getCurrentQuantity());
			fieldsToVerify.put("reorderLevel", dto.getReorderLevel());
			fieldsToVerify.put("alertDate", dto.getAlertDate());
			fieldsToVerify.put("alertSent", dto.getAlertSent());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if stockAlerts to insert do not exist
			StockAlerts existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("stockAlerts alertId -> " + dto.getAlertId(), locale));
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
				StockAlerts entityToSave = null;
			entityToSave = StockAlertsTransformer.INSTANCE.toEntity(dto, existingProducts, existingPharmacies);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<StockAlerts> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = stockAlertsRepository.saveAll((Iterable<StockAlerts>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("stockAlerts", locale));
				response.setHasError(true);
				return response;
			}
			List<StockAlertsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockAlertsTransformer.INSTANCE.toLiteDtos(itemsSaved) : StockAlertsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create StockAlerts-----");
		return response;
	}

	/**
	 * update StockAlerts by using StockAlertsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAlertsDto> update(Request<StockAlertsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update StockAlerts-----");

		Response<StockAlertsDto> response = new Response<StockAlertsDto>();
		List<StockAlerts>        items    = new ArrayList<StockAlerts>();
			
		for (StockAlertsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("alertId", dto.getAlertId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la stockAlerts existe
			StockAlerts entityToSave = null;
			entityToSave = stockAlertsRepository.findOne(dto.getAlertId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stockAlerts alertId -> " + dto.getAlertId(), locale));
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
			if (dto.getCurrentQuantity() != null && dto.getCurrentQuantity() > 0) {
				entityToSave.setCurrentQuantity(dto.getCurrentQuantity());
			}
			if (dto.getReorderLevel() != null && dto.getReorderLevel() > 0) {
				entityToSave.setReorderLevel(dto.getReorderLevel());
			}
			if (Utilities.notBlank(dto.getAlertDate())) {
				entityToSave.setAlertDate(dateFormat.parse(dto.getAlertDate()));
			}
			if (dto.getAlertSent() != null) {
				entityToSave.setAlertSent(dto.getAlertSent());
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
			List<StockAlerts> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = stockAlertsRepository.saveAll((Iterable<StockAlerts>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("stockAlerts", locale));
				response.setHasError(true);
				return response;
			}
			List<StockAlertsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockAlertsTransformer.INSTANCE.toLiteDtos(itemsSaved) : StockAlertsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update StockAlerts-----");
		return response;
	}

	/**
	 * delete StockAlerts by using StockAlertsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAlertsDto> delete(Request<StockAlertsDto> request, Locale locale)  {
		log.info("----begin delete StockAlerts-----");

		Response<StockAlertsDto> response = new Response<StockAlertsDto>();
		List<StockAlerts>        items    = new ArrayList<StockAlerts>();
			
		for (StockAlertsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("alertId", dto.getAlertId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la stockAlerts existe
			StockAlerts existingEntity = null;
			existingEntity = stockAlertsRepository.findOne(dto.getAlertId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stockAlerts -> " + dto.getAlertId(), locale));
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
			stockAlertsRepository.saveAll((Iterable<StockAlerts>) items);

			response.setHasError(false);
		}

		log.info("----end delete StockAlerts-----");
		return response;
	}

	/**
	 * get StockAlerts by using StockAlertsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockAlertsDto> getByCriteria(Request<StockAlertsDto> request, Locale locale)  throws Exception {
		log.info("----begin get StockAlerts-----");

		Response<StockAlertsDto> response = new Response<StockAlertsDto>();
		List<StockAlerts> items 			 = stockAlertsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<StockAlertsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockAlertsTransformer.INSTANCE.toLiteDtos(items) : StockAlertsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(stockAlertsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("stockAlerts", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get StockAlerts-----");
		return response;
	}

	/**
	 * get full StockAlertsDto by using StockAlerts as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private StockAlertsDto getFullInfos(StockAlertsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
