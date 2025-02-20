                                                            													
/*
 * Java business for entity table product_categories 
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
import dev.backend.epharmaApp.dao.entity.ProductCategories;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "product_categories"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ProductCategoriesBusiness implements IBasicBusiness<Request<ProductCategoriesDto>, Response<ProductCategoriesDto>> {

	private Response<ProductCategoriesDto> response;
	@Autowired
	private ProductCategoriesRepository productCategoriesRepository;
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

	public ProductCategoriesBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ProductCategories by using ProductCategoriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductCategoriesDto> create(Request<ProductCategoriesDto> request, Locale locale)  throws ParseException {
		log.info("----begin create ProductCategories-----");

		Response<ProductCategoriesDto> response = new Response<ProductCategoriesDto>();
		List<ProductCategories>        items    = new ArrayList<ProductCategories>();
			
		for (ProductCategoriesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("categoryName", dto.getCategoryName());
			fieldsToVerify.put("categoryDescription", dto.getCategoryDescription());
			fieldsToVerify.put("parentCategoryId", dto.getParentCategoryId());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if productCategories to insert do not exist
			ProductCategories existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("productCategories categoryId -> " + dto.getCategoryId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if productCategories exist
			ProductCategories existingProductCategories = null;
			if (dto.getParentCategoryId() != null && dto.getParentCategoryId() > 0){
				existingProductCategories = productCategoriesRepository.findOne(dto.getParentCategoryId(), false);
				if (existingProductCategories == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("productCategories parentCategoryId -> " + dto.getParentCategoryId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				ProductCategories entityToSave = null;
			entityToSave = ProductCategoriesTransformer.INSTANCE.toEntity(dto, existingProductCategories);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ProductCategories> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = productCategoriesRepository.saveAll((Iterable<ProductCategories>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("productCategories", locale));
				response.setHasError(true);
				return response;
			}
			List<ProductCategoriesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductCategoriesTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProductCategoriesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create ProductCategories-----");
		return response;
	}

	/**
	 * update ProductCategories by using ProductCategoriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductCategoriesDto> update(Request<ProductCategoriesDto> request, Locale locale)  throws ParseException {
		log.info("----begin update ProductCategories-----");

		Response<ProductCategoriesDto> response = new Response<ProductCategoriesDto>();
		List<ProductCategories>        items    = new ArrayList<ProductCategories>();
			
		for (ProductCategoriesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("categoryId", dto.getCategoryId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la productCategories existe
			ProductCategories entityToSave = null;
			entityToSave = productCategoriesRepository.findOne(dto.getCategoryId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("productCategories categoryId -> " + dto.getCategoryId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if productCategories exist
			if (dto.getParentCategoryId() != null && dto.getParentCategoryId() > 0){
				ProductCategories existingProductCategories = productCategoriesRepository.findOne(dto.getParentCategoryId(), false);
				if (existingProductCategories == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("productCategories parentCategoryId -> " + dto.getParentCategoryId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setProductCategories(existingProductCategories);
			}
			if (Utilities.notBlank(dto.getCategoryName())) {
				entityToSave.setCategoryName(dto.getCategoryName());
			}
			if (Utilities.notBlank(dto.getCategoryDescription())) {
				entityToSave.setCategoryDescription(dto.getCategoryDescription());
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
			List<ProductCategories> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = productCategoriesRepository.saveAll((Iterable<ProductCategories>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("productCategories", locale));
				response.setHasError(true);
				return response;
			}
			List<ProductCategoriesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductCategoriesTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProductCategoriesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update ProductCategories-----");
		return response;
	}

	/**
	 * delete ProductCategories by using ProductCategoriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductCategoriesDto> delete(Request<ProductCategoriesDto> request, Locale locale)  {
		log.info("----begin delete ProductCategories-----");

		Response<ProductCategoriesDto> response = new Response<ProductCategoriesDto>();
		List<ProductCategories>        items    = new ArrayList<ProductCategories>();
			
		for (ProductCategoriesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("categoryId", dto.getCategoryId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la productCategories existe
			ProductCategories existingEntity = null;
			existingEntity = productCategoriesRepository.findOne(dto.getCategoryId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("productCategories -> " + dto.getCategoryId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// products
			List<Products> listOfProducts = productsRepository.findByCategoryId(existingEntity.getCategoryId(), false);
			if (listOfProducts != null && !listOfProducts.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfProducts.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// productCategories
			List<ProductCategories> listOfProductCategories = productCategoriesRepository.findByParentCategoryId(existingEntity.getCategoryId(), false);
			if (listOfProductCategories != null && !listOfProductCategories.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfProductCategories.size() + ")", locale));
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
			productCategoriesRepository.saveAll((Iterable<ProductCategories>) items);

			response.setHasError(false);
		}

		log.info("----end delete ProductCategories-----");
		return response;
	}

	/**
	 * get ProductCategories by using ProductCategoriesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProductCategoriesDto> getByCriteria(Request<ProductCategoriesDto> request, Locale locale)  throws Exception {
		log.info("----begin get ProductCategories-----");

		Response<ProductCategoriesDto> response = new Response<ProductCategoriesDto>();
		List<ProductCategories> items 			 = productCategoriesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ProductCategoriesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProductCategoriesTransformer.INSTANCE.toLiteDtos(items) : ProductCategoriesTransformer.INSTANCE.toDtos(items);

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
			response.setCount(productCategoriesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("productCategories", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get ProductCategories-----");
		return response;
	}

	/**
	 * get full ProductCategoriesDto by using ProductCategories as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ProductCategoriesDto getFullInfos(ProductCategoriesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
