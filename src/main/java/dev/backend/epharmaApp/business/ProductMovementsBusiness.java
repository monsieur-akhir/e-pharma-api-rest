                                                                        																
/*
 * Java business for entity table product_movements 
 * Created on 2025-02-15 ( Time 03:02:44 )
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
import dev.backend.epharmaApp.dao.entity.ProductMovements;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "product_movements"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ProductMovementsBusiness implements IBasicBusiness<Request<ProductMovementsDto>, Response<ProductMovementsDto>> {

	private Response<ProductMovementsDto> response;
	@Autowired
	private ProductMovementsRepository productMovementsRepository;
	@Autowired
	private ProductsRepository productsRepository;
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

	public ProductMovementsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ProductMovements by using ProductMovementsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductMovementsDto> create(Request<ProductMovementsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create ProductMovements-----");

		Response<ProductMovementsDto> response = new Response<ProductMovementsDto>();
		List<ProductMovements>        items    = new ArrayList<ProductMovements>();
			
		for (ProductMovementsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("productId", dto.getProductId());
			fieldsToVerify.put("fromEntity", dto.getFromEntity());
			fieldsToVerify.put("toEntity", dto.getToEntity());
			fieldsToVerify.put("movementDate", dto.getMovementDate());
			fieldsToVerify.put("quantity", dto.getQuantity());
			fieldsToVerify.put("remarks", dto.getRemarks());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if productMovements to insert do not exist
			ProductMovements existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("productMovements movementId -> " + dto.getMovementId(), locale));
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
				ProductMovements entityToSave = null;
			entityToSave = ProductMovementsTransformer.INSTANCE.toEntity(dto, existingProducts);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ProductMovements> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = productMovementsRepository.saveAll((Iterable<ProductMovements>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("productMovements", locale));
				response.setHasError(true);
				return response;
			}
			List<ProductMovementsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductMovementsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProductMovementsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create ProductMovements-----");
		return response;
	}

	/**
	 * update ProductMovements by using ProductMovementsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductMovementsDto> update(Request<ProductMovementsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update ProductMovements-----");

		Response<ProductMovementsDto> response = new Response<ProductMovementsDto>();
		List<ProductMovements>        items    = new ArrayList<ProductMovements>();
			
		for (ProductMovementsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("movementId", dto.getMovementId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la productMovements existe
			ProductMovements entityToSave = null;
			entityToSave = productMovementsRepository.findOne(dto.getMovementId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("productMovements movementId -> " + dto.getMovementId(), locale));
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
			if (Utilities.notBlank(dto.getFromEntity())) {
				entityToSave.setFromEntity(dto.getFromEntity());
			}
			if (Utilities.notBlank(dto.getToEntity())) {
				entityToSave.setToEntity(dto.getToEntity());
			}
			if (Utilities.notBlank(dto.getMovementDate())) {
				entityToSave.setMovementDate(dateFormat.parse(dto.getMovementDate()));
			}
			if (dto.getQuantity() != null && dto.getQuantity() > 0) {
				entityToSave.setQuantity(dto.getQuantity());
			}
			if (Utilities.notBlank(dto.getRemarks())) {
				entityToSave.setRemarks(dto.getRemarks());
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
			List<ProductMovements> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = productMovementsRepository.saveAll((Iterable<ProductMovements>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("productMovements", locale));
				response.setHasError(true);
				return response;
			}
			List<ProductMovementsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductMovementsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProductMovementsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update ProductMovements-----");
		return response;
	}

	/**
	 * delete ProductMovements by using ProductMovementsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductMovementsDto> delete(Request<ProductMovementsDto> request, Locale locale)  {
		log.info("----begin delete ProductMovements-----");

		Response<ProductMovementsDto> response = new Response<ProductMovementsDto>();
		List<ProductMovements>        items    = new ArrayList<ProductMovements>();
			
		for (ProductMovementsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("movementId", dto.getMovementId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la productMovements existe
			ProductMovements existingEntity = null;
			existingEntity = productMovementsRepository.findOne(dto.getMovementId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("productMovements -> " + dto.getMovementId(), locale));
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
			productMovementsRepository.saveAll((Iterable<ProductMovements>) items);

			response.setHasError(false);
		}

		log.info("----end delete ProductMovements-----");
		return response;
	}

	/**
	 * get ProductMovements by using ProductMovementsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductMovementsDto> getByCriteria(Request<ProductMovementsDto> request, Locale locale)  throws Exception {
		log.info("----begin get ProductMovements-----");

		Response<ProductMovementsDto> response = new Response<ProductMovementsDto>();
		List<ProductMovements> items 			 = productMovementsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ProductMovementsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductMovementsTransformer.INSTANCE.toLiteDtos(items) : ProductMovementsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(productMovementsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("productMovements", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get ProductMovements-----");
		return response;
	}

	/**
	 * get full ProductMovementsDto by using ProductMovements as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ProductMovementsDto getFullInfos(ProductMovementsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
