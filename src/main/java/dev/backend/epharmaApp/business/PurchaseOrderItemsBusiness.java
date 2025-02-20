                                                                    															
/*
 * Java business for entity table purchase_order_items 
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
import dev.backend.epharmaApp.dao.entity.PurchaseOrderItems;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.PurchaseOrders;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "purchase_order_items"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class PurchaseOrderItemsBusiness implements IBasicBusiness<Request<PurchaseOrderItemsDto>, Response<PurchaseOrderItemsDto>> {

	private Response<PurchaseOrderItemsDto> response;
	@Autowired
	private PurchaseOrderItemsRepository purchaseOrderItemsRepository;
	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private PurchaseOrdersRepository purchaseOrdersRepository;
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

	public PurchaseOrderItemsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create PurchaseOrderItems by using PurchaseOrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrderItemsDto> create(Request<PurchaseOrderItemsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create PurchaseOrderItems-----");

		Response<PurchaseOrderItemsDto> response = new Response<PurchaseOrderItemsDto>();
		List<PurchaseOrderItems>        items    = new ArrayList<PurchaseOrderItems>();
			
		for (PurchaseOrderItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("poId", dto.getPoId());
			fieldsToVerify.put("productId", dto.getProductId());
			fieldsToVerify.put("quantity", dto.getQuantity());
			fieldsToVerify.put("unitPrice", dto.getUnitPrice());
			fieldsToVerify.put("totalPrice", dto.getTotalPrice());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if purchaseOrderItems to insert do not exist
			PurchaseOrderItems existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("purchaseOrderItems poItemId -> " + dto.getPoItemId(), locale));
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
			// Verify if purchaseOrders exist
			PurchaseOrders existingPurchaseOrders = null;
			if (dto.getPoId() != null && dto.getPoId() > 0){
				existingPurchaseOrders = purchaseOrdersRepository.findOne(dto.getPoId(), false);
				if (existingPurchaseOrders == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("purchaseOrders poId -> " + dto.getPoId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				PurchaseOrderItems entityToSave = null;
			entityToSave = PurchaseOrderItemsTransformer.INSTANCE.toEntity(dto, existingProducts, existingPurchaseOrders);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PurchaseOrderItems> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = purchaseOrderItemsRepository.saveAll((Iterable<PurchaseOrderItems>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("purchaseOrderItems", locale));
				response.setHasError(true);
				return response;
			}
			List<PurchaseOrderItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PurchaseOrderItemsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PurchaseOrderItemsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create PurchaseOrderItems-----");
		return response;
	}

	/**
	 * update PurchaseOrderItems by using PurchaseOrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrderItemsDto> update(Request<PurchaseOrderItemsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update PurchaseOrderItems-----");

		Response<PurchaseOrderItemsDto> response = new Response<PurchaseOrderItemsDto>();
		List<PurchaseOrderItems>        items    = new ArrayList<PurchaseOrderItems>();
			
		for (PurchaseOrderItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("poItemId", dto.getPoItemId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la purchaseOrderItems existe
			PurchaseOrderItems entityToSave = null;
			entityToSave = purchaseOrderItemsRepository.findOne(dto.getPoItemId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("purchaseOrderItems poItemId -> " + dto.getPoItemId(), locale));
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
			// Verify if purchaseOrders exist
			if (dto.getPoId() != null && dto.getPoId() > 0){
				PurchaseOrders existingPurchaseOrders = purchaseOrdersRepository.findOne(dto.getPoId(), false);
				if (existingPurchaseOrders == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("purchaseOrders poId -> " + dto.getPoId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setPurchaseOrders(existingPurchaseOrders);
			}
			if (dto.getQuantity() != null && dto.getQuantity() > 0) {
				entityToSave.setQuantity(dto.getQuantity());
			}
			if (dto.getUnitPrice() != null && dto.getUnitPrice() > 0) {
				entityToSave.setUnitPrice(dto.getUnitPrice());
			}
			if (dto.getTotalPrice() != null && dto.getTotalPrice() > 0) {
				entityToSave.setTotalPrice(dto.getTotalPrice());
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
			List<PurchaseOrderItems> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = purchaseOrderItemsRepository.saveAll((Iterable<PurchaseOrderItems>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("purchaseOrderItems", locale));
				response.setHasError(true);
				return response;
			}
			List<PurchaseOrderItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PurchaseOrderItemsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PurchaseOrderItemsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update PurchaseOrderItems-----");
		return response;
	}

	/**
	 * delete PurchaseOrderItems by using PurchaseOrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrderItemsDto> delete(Request<PurchaseOrderItemsDto> request, Locale locale)  {
		log.info("----begin delete PurchaseOrderItems-----");

		Response<PurchaseOrderItemsDto> response = new Response<PurchaseOrderItemsDto>();
		List<PurchaseOrderItems>        items    = new ArrayList<PurchaseOrderItems>();
			
		for (PurchaseOrderItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("poItemId", dto.getPoItemId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la purchaseOrderItems existe
			PurchaseOrderItems existingEntity = null;
			existingEntity = purchaseOrderItemsRepository.findOne(dto.getPoItemId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("purchaseOrderItems -> " + dto.getPoItemId(), locale));
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
			purchaseOrderItemsRepository.saveAll((Iterable<PurchaseOrderItems>) items);

			response.setHasError(false);
		}

		log.info("----end delete PurchaseOrderItems-----");
		return response;
	}

	/**
	 * get PurchaseOrderItems by using PurchaseOrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PurchaseOrderItemsDto> getByCriteria(Request<PurchaseOrderItemsDto> request, Locale locale)  throws Exception {
		log.info("----begin get PurchaseOrderItems-----");

		Response<PurchaseOrderItemsDto> response = new Response<PurchaseOrderItemsDto>();
		List<PurchaseOrderItems> items 			 = purchaseOrderItemsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PurchaseOrderItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PurchaseOrderItemsTransformer.INSTANCE.toLiteDtos(items) : PurchaseOrderItemsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(purchaseOrderItemsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("purchaseOrderItems", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get PurchaseOrderItems-----");
		return response;
	}

	/**
	 * get full PurchaseOrderItemsDto by using PurchaseOrderItems as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PurchaseOrderItemsDto getFullInfos(PurchaseOrderItemsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
