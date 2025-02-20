                                                                                        																				
/*
 * Java business for entity table products 
 * Created on 2025-02-15 ( Time 03:02:45 )
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
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.ProductCategories;
import dev.backend.epharmaApp.dao.entity.Manufacturers;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "products"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ProductsBusiness implements IBasicBusiness<Request<ProductsDto>, Response<ProductsDto>> {

	private Response<ProductsDto> response;
	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	@Autowired
	private NoticesRepository noticesRepository;
	@Autowired
	private ProductCategoriesRepository productCategoriesRepository;
	@Autowired
	private StockAlertsRepository stockAlertsRepository;
	@Autowired
	private ManufacturersRepository manufacturersRepository;
	@Autowired
	private ProductMovementsRepository productMovementsRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private PurchaseOrderItemsRepository purchaseOrderItemsRepository;
	@Autowired
	private PrescriptionItemsRepository prescriptionItemsRepository;
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

	public ProductsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Products by using ProductsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductsDto> create(Request<ProductsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Products-----");

		Response<ProductsDto> response = new Response<ProductsDto>();
		List<Products>        items    = new ArrayList<Products>();
			
		for (ProductsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("productName", dto.getProductName());
			fieldsToVerify.put("genericName", dto.getGenericName());
			fieldsToVerify.put("brandName", dto.getBrandName());
			fieldsToVerify.put("description", dto.getDescription());
			fieldsToVerify.put("categoryId", dto.getCategoryId());
			fieldsToVerify.put("dosage", dto.getDosage());
			fieldsToVerify.put("price", dto.getPrice());
			fieldsToVerify.put("barcode", dto.getBarcode());
			fieldsToVerify.put("expirationDate", dto.getExpirationDate());
			fieldsToVerify.put("manufacturerId", dto.getManufacturerId());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if products to insert do not exist
			Products existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("products productId -> " + dto.getProductId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if productCategories exist
			ProductCategories existingProductCategories = null;
			if (dto.getCategoryId() != null && dto.getCategoryId() > 0){
				existingProductCategories = productCategoriesRepository.findOne(dto.getCategoryId(), false);
				if (existingProductCategories == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("productCategories categoryId -> " + dto.getCategoryId(), locale));
					response.setHasError(true);
					return response;
				}
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
				Products entityToSave = null;
			entityToSave = ProductsTransformer.INSTANCE.toEntity(dto, existingProductCategories, existingManufacturers);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Products> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = productsRepository.saveAll((Iterable<Products>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("products", locale));
				response.setHasError(true);
				return response;
			}
			List<ProductsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProductsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Products-----");
		return response;
	}

	/**
	 * update Products by using ProductsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductsDto> update(Request<ProductsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Products-----");

		Response<ProductsDto> response = new Response<ProductsDto>();
		List<Products>        items    = new ArrayList<Products>();
			
		for (ProductsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("productId", dto.getProductId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la products existe
			Products entityToSave = null;
			entityToSave = productsRepository.findOne(dto.getProductId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("products productId -> " + dto.getProductId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if productCategories exist
			if (dto.getCategoryId() != null && dto.getCategoryId() > 0){
				ProductCategories existingProductCategories = productCategoriesRepository.findOne(dto.getCategoryId(), false);
				if (existingProductCategories == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("productCategories categoryId -> " + dto.getCategoryId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setProductCategories(existingProductCategories);
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
			if (Utilities.notBlank(dto.getProductName())) {
				entityToSave.setProductName(dto.getProductName());
			}
			if (Utilities.notBlank(dto.getGenericName())) {
				entityToSave.setGenericName(dto.getGenericName());
			}
			if (Utilities.notBlank(dto.getBrandName())) {
				entityToSave.setBrandName(dto.getBrandName());
			}
			if (Utilities.notBlank(dto.getDescription())) {
				entityToSave.setDescription(dto.getDescription());
			}
			if (Utilities.notBlank(dto.getDosage())) {
				entityToSave.setDosage(dto.getDosage());
			}
			if (dto.getPrice() != null && dto.getPrice() > 0) {
				entityToSave.setPrice(dto.getPrice());
			}
			if (Utilities.notBlank(dto.getBarcode())) {
				entityToSave.setBarcode(dto.getBarcode());
			}
			if (dto.getExpirationDate() != null) {
				entityToSave.setExpirationDate(dto.getExpirationDate());
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
			List<Products> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = productsRepository.saveAll((Iterable<Products>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("products", locale));
				response.setHasError(true);
				return response;
			}
			List<ProductsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductsTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProductsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Products-----");
		return response;
	}

	/**
	 * delete Products by using ProductsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductsDto> delete(Request<ProductsDto> request, Locale locale)  {
		log.info("----begin delete Products-----");

		Response<ProductsDto> response = new Response<ProductsDto>();
		List<Products>        items    = new ArrayList<Products>();
			
		for (ProductsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("productId", dto.getProductId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la products existe
			Products existingEntity = null;
			existingEntity = productsRepository.findOne(dto.getProductId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("products -> " + dto.getProductId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// orderItems
			List<OrderItems> listOfOrderItems = orderItemsRepository.findByProductId(existingEntity.getProductId(), false);
			if (listOfOrderItems != null && !listOfOrderItems.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfOrderItems.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// notices
			List<Notices> listOfNotices = noticesRepository.findByProductId(existingEntity.getProductId(), false);
			if (listOfNotices != null && !listOfNotices.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfNotices.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// stockAlerts
			List<StockAlerts> listOfStockAlerts = stockAlertsRepository.findByProductId(existingEntity.getProductId(), false);
			if (listOfStockAlerts != null && !listOfStockAlerts.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfStockAlerts.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// productMovements
			List<ProductMovements> listOfProductMovements = productMovementsRepository.findByProductId(existingEntity.getProductId(), false);
			if (listOfProductMovements != null && !listOfProductMovements.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfProductMovements.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// stock
			List<Stock> listOfStock = stockRepository.findByProductId(existingEntity.getProductId(), false);
			if (listOfStock != null && !listOfStock.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfStock.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// purchaseOrderItems
			List<PurchaseOrderItems> listOfPurchaseOrderItems = purchaseOrderItemsRepository.findByProductId(existingEntity.getProductId(), false);
			if (listOfPurchaseOrderItems != null && !listOfPurchaseOrderItems.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPurchaseOrderItems.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// prescriptionItems
			List<PrescriptionItems> listOfPrescriptionItems = prescriptionItemsRepository.findByProductId(existingEntity.getProductId(), false);
			if (listOfPrescriptionItems != null && !listOfPrescriptionItems.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrescriptionItems.size() + ")", locale));
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
			productsRepository.saveAll((Iterable<Products>) items);

			response.setHasError(false);
		}

		log.info("----end delete Products-----");
		return response;
	}

	/**
	 * get Products by using ProductsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductsDto> getByCriteria(Request<ProductsDto> request, Locale locale)  throws Exception {
		log.info("----begin get Products-----");

		Response<ProductsDto> response = new Response<ProductsDto>();
		List<Products> items 			 = productsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ProductsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductsTransformer.INSTANCE.toLiteDtos(items) : ProductsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(productsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("products", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Products-----");
		return response;
	}

	/**
	 * get full ProductsDto by using Products as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ProductsDto getFullInfos(ProductsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
