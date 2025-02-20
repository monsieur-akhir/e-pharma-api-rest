                                                                    															
/*
 * Java business for entity table order_items 
 * Created on 2025-02-15 ( Time 03:02:42 )
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
import dev.backend.epharmaApp.dao.entity.OrderItems;
import dev.backend.epharmaApp.dao.entity.Orders;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "order_items"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class OrderItemsBusiness implements IBasicBusiness<Request<OrderItemsDto>, Response<OrderItemsDto>> {

	private Response<OrderItemsDto> response;
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	@Autowired
	private OrdersRepository ordersRepository;
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

	public OrderItemsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create OrderItems by using OrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrderItemsDto> create(Request<OrderItemsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create OrderItems-----");

		Response<OrderItemsDto> response = new Response<OrderItemsDto>();
		List<OrderItems>        items    = new ArrayList<OrderItems>();
			
		for (OrderItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("orderId", dto.getOrderId());
			fieldsToVerify.put("productId", dto.getProductId());
			fieldsToVerify.put("quantity", dto.getQuantity());
			fieldsToVerify.put("unitPrice", dto.getUnitPrice());
			fieldsToVerify.put("totalPrice", dto.getTotalPrice());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if orderItems to insert do not exist
			OrderItems existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("orderItems orderItemId -> " + dto.getOrderItemId(), locale));
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
				OrderItems entityToSave = null;
			entityToSave = OrderItemsTransformer.INSTANCE.toEntity(dto, existingOrders, existingProducts);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<OrderItems> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = orderItemsRepository.saveAll((Iterable<OrderItems>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("orderItems", locale));
				response.setHasError(true);
				return response;
			}
			List<OrderItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrderItemsTransformer.INSTANCE.toLiteDtos(itemsSaved) : OrderItemsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create OrderItems-----");
		return response;
	}

	/**
	 * update OrderItems by using OrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrderItemsDto> update(Request<OrderItemsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update OrderItems-----");

		Response<OrderItemsDto> response = new Response<OrderItemsDto>();
		List<OrderItems>        items    = new ArrayList<OrderItems>();
			
		for (OrderItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("orderItemId", dto.getOrderItemId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la orderItems existe
			OrderItems entityToSave = null;
			entityToSave = orderItemsRepository.findOne(dto.getOrderItemId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("orderItems orderItemId -> " + dto.getOrderItemId(), locale));
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
			List<OrderItems> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = orderItemsRepository.saveAll((Iterable<OrderItems>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("orderItems", locale));
				response.setHasError(true);
				return response;
			}
			List<OrderItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrderItemsTransformer.INSTANCE.toLiteDtos(itemsSaved) : OrderItemsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update OrderItems-----");
		return response;
	}

	/**
	 * delete OrderItems by using OrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrderItemsDto> delete(Request<OrderItemsDto> request, Locale locale)  {
		log.info("----begin delete OrderItems-----");

		Response<OrderItemsDto> response = new Response<OrderItemsDto>();
		List<OrderItems>        items    = new ArrayList<OrderItems>();
			
		for (OrderItemsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("orderItemId", dto.getOrderItemId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la orderItems existe
			OrderItems existingEntity = null;
			existingEntity = orderItemsRepository.findOne(dto.getOrderItemId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("orderItems -> " + dto.getOrderItemId(), locale));
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
			orderItemsRepository.saveAll((Iterable<OrderItems>) items);

			response.setHasError(false);
		}

		log.info("----end delete OrderItems-----");
		return response;
	}

	/**
	 * get OrderItems by using OrderItemsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrderItemsDto> getByCriteria(Request<OrderItemsDto> request, Locale locale)  throws Exception {
		log.info("----begin get OrderItems-----");

		Response<OrderItemsDto> response = new Response<OrderItemsDto>();
		List<OrderItems> items 			 = orderItemsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<OrderItemsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrderItemsTransformer.INSTANCE.toLiteDtos(items) : OrderItemsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(orderItemsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("orderItems", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get OrderItems-----");
		return response;
	}

	/**
	 * get full OrderItemsDto by using OrderItems as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private OrderItemsDto getFullInfos(OrderItemsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
