                                                            													
/*
 * Java business for entity table stock 
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
import dev.backend.epharmaApp.dao.entity.Stock;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "stock"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class StockBusiness implements IBasicBusiness<Request<StockDto>, Response<StockDto>> {

	private Response<StockDto> response;
	@Autowired
	private StockRepository stockRepository;
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

	public StockBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Stock by using StockDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockDto> create(Request<StockDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Stock-----");

		Response<StockDto> response = new Response<StockDto>();
		List<Stock>        items    = new ArrayList<Stock>();
			
		for (StockDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("quantity", dto.getQuantity());
			fieldsToVerify.put("reorderLevel", dto.getReorderLevel());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if stock to insert do not exist
			Stock existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("stock pharmacyId -> " + dto.getPharmacyId(), locale));
				response.setHasError(true);
				return response;
			}

			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("stock productId -> " + dto.getProductId(), locale));
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
				Stock entityToSave = null;
			entityToSave = StockTransformer.INSTANCE.toEntity(dto, existingProducts, existingPharmacies);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Stock> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = stockRepository.saveAll((Iterable<Stock>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("stock", locale));
				response.setHasError(true);
				return response;
			}
			List<StockDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockTransformer.INSTANCE.toLiteDtos(itemsSaved) : StockTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Stock-----");
		return response;
	}

	/**
	 * update Stock by using StockDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockDto> update(Request<StockDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Stock-----");

		Response<StockDto> response = new Response<StockDto>();
		List<Stock>        items    = new ArrayList<Stock>();
			
		for (StockDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la stock existe
			Stock entityToSave = null;
			entityToSave = stockRepository.findOneByPharmacyId(dto.getPharmacyId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stock pharmacyId -> " + dto.getPharmacyId(), locale));
				response.setHasError(true);
				return response;
			}
			entityToSave = stockRepository.findOneByProductId(dto.getProductId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stock productId -> " + dto.getProductId(), locale));
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
			if (dto.getQuantity() != null && dto.getQuantity() > 0) {
				entityToSave.setQuantity(dto.getQuantity());
			}
			if (dto.getReorderLevel() != null && dto.getReorderLevel() > 0) {
				entityToSave.setReorderLevel(dto.getReorderLevel());
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
			List<Stock> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = stockRepository.saveAll((Iterable<Stock>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("stock", locale));
				response.setHasError(true);
				return response;
			}
			List<StockDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockTransformer.INSTANCE.toLiteDtos(itemsSaved) : StockTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Stock-----");
		return response;
	}

	/**
	 * delete Stock by using StockDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockDto> delete(Request<StockDto> request, Locale locale)  {
		log.info("----begin delete Stock-----");

		Response<StockDto> response = new Response<StockDto>();
		List<Stock>        items    = new ArrayList<Stock>();
			
		for (StockDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("pharmacyId", dto.getPharmacyId());
			fieldsToVerify.put("productId", dto.getProductId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la stock existe
			Stock existingEntity = null;
			existingEntity = stockRepository.findOneByPharmacyId(dto.getPharmacyId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stock -> " + dto.getPharmacyId(), locale));
				response.setHasError(true);
				return response;
			}
			existingEntity = stockRepository.findOneByProductId(dto.getProductId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("stock -> " + dto.getProductId(), locale));
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
			stockRepository.saveAll((Iterable<Stock>) items);

			response.setHasError(false);
		}

		log.info("----end delete Stock-----");
		return response;
	}

	/**
	 * get Stock by using StockDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<StockDto> getByCriteria(Request<StockDto> request, Locale locale)  throws Exception {
		log.info("----begin get Stock-----");

		Response<StockDto> response = new Response<StockDto>();
		List<Stock> items 			 = stockRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<StockDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? StockTransformer.INSTANCE.toLiteDtos(items) : StockTransformer.INSTANCE.toDtos(items);

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
			response.setCount(stockRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("stock", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Stock-----");
		return response;
	}

	/**
	 * get full StockDto by using Stock as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private StockDto getFullInfos(StockDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
