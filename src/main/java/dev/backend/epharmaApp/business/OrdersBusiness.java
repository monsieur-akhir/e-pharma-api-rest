                                                                    															
/*
 * Java business for entity table orders 
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
import dev.backend.epharmaApp.dao.entity.Orders;
import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "orders"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class OrdersBusiness implements IBasicBusiness<Request<OrdersDto>, Response<OrdersDto>> {

	private Response<OrdersDto> response;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private DeliveriesRepository deliveriesRepository;
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	@Autowired
	private ClientsRepository clientsRepository;
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

	public OrdersBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Orders by using OrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdersDto> create(Request<OrdersDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Orders-----");

		Response<OrdersDto> response = new Response<OrdersDto>();
		List<Orders>        items    = new ArrayList<Orders>();
			
		for (OrdersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("clientId", dto.getClientId());
			fieldsToVerify.put("orderDate", dto.getOrderDate());
			fieldsToVerify.put("orderStatus", dto.getOrderStatus());
			fieldsToVerify.put("totalAmount", dto.getTotalAmount());
			fieldsToVerify.put("paymentMethod", dto.getPaymentMethod());
			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if orders to insert do not exist
			Orders existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("orders orderId -> " + dto.getOrderId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if clients exist
			Clients existingClients = null;
			if (dto.getClientId() != null && dto.getClientId() > 0){
				existingClients = clientsRepository.findOne(dto.getClientId(), false);
				if (existingClients == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("clients clientId -> " + dto.getClientId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				Orders entityToSave = null;
			entityToSave = OrdersTransformer.INSTANCE.toEntity(dto, existingClients);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Orders> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = ordersRepository.saveAll((Iterable<Orders>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("orders", locale));
				response.setHasError(true);
				return response;
			}
			List<OrdersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdersTransformer.INSTANCE.toLiteDtos(itemsSaved) : OrdersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Orders-----");
		return response;
	}

	/**
	 * update Orders by using OrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdersDto> update(Request<OrdersDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Orders-----");

		Response<OrdersDto> response = new Response<OrdersDto>();
		List<Orders>        items    = new ArrayList<Orders>();
			
		for (OrdersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("orderId", dto.getOrderId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la orders existe
			Orders entityToSave = null;
			entityToSave = ordersRepository.findOne(dto.getOrderId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("orders orderId -> " + dto.getOrderId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if clients exist
			if (dto.getClientId() != null && dto.getClientId() > 0){
				Clients existingClients = clientsRepository.findOne(dto.getClientId(), false);
				if (existingClients == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("clients clientId -> " + dto.getClientId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setClients(existingClients);
			}
			if (Utilities.notBlank(dto.getOrderDate())) {
				entityToSave.setOrderDate(dateFormat.parse(dto.getOrderDate()));
			}
			if (Utilities.notBlank(dto.getOrderStatus())) {
				entityToSave.setOrderStatus(dto.getOrderStatus());
			}
			if (dto.getTotalAmount() != null && dto.getTotalAmount() > 0) {
				entityToSave.setTotalAmount(dto.getTotalAmount());
			}
			if (Utilities.notBlank(dto.getPaymentMethod())) {
				entityToSave.setPaymentMethod(dto.getPaymentMethod());
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
			List<Orders> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = ordersRepository.saveAll((Iterable<Orders>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("orders", locale));
				response.setHasError(true);
				return response;
			}
			List<OrdersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdersTransformer.INSTANCE.toLiteDtos(itemsSaved) : OrdersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Orders-----");
		return response;
	}

	/**
	 * delete Orders by using OrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdersDto> delete(Request<OrdersDto> request, Locale locale)  {
		log.info("----begin delete Orders-----");

		Response<OrdersDto> response = new Response<OrdersDto>();
		List<Orders>        items    = new ArrayList<Orders>();
			
		for (OrdersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("orderId", dto.getOrderId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la orders existe
			Orders existingEntity = null;
			existingEntity = ordersRepository.findOne(dto.getOrderId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("orders -> " + dto.getOrderId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// deliveries
			List<Deliveries> listOfDeliveries = deliveriesRepository.findByOrderId(existingEntity.getOrderId(), false);
			if (listOfDeliveries != null && !listOfDeliveries.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfDeliveries.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// orderItems
			List<OrderItems> listOfOrderItems = orderItemsRepository.findByOrderId(existingEntity.getOrderId(), false);
			if (listOfOrderItems != null && !listOfOrderItems.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfOrderItems.size() + ")", locale));
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
			ordersRepository.saveAll((Iterable<Orders>) items);

			response.setHasError(false);
		}

		log.info("----end delete Orders-----");
		return response;
	}

	/**
	 * get Orders by using OrdersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<OrdersDto> getByCriteria(Request<OrdersDto> request, Locale locale)  throws Exception {
		log.info("----begin get Orders-----");

		Response<OrdersDto> response = new Response<OrdersDto>();
		List<Orders> items 			 = ordersRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<OrdersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? OrdersTransformer.INSTANCE.toLiteDtos(items) : OrdersTransformer.INSTANCE.toDtos(items);

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
			response.setCount(ordersRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("orders", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Orders-----");
		return response;
	}

	/**
	 * get full OrdersDto by using Orders as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private OrdersDto getFullInfos(OrdersDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
