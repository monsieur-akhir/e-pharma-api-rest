                                                                														
/*
 * Java business for entity table manufacturers 
 * Created on 2025-02-15 ( Time 03:02:41 )
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
import dev.backend.epharmaApp.dao.entity.Manufacturers;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "manufacturers"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ManufacturersBusiness implements IBasicBusiness<Request<ManufacturersDto>, Response<ManufacturersDto>> {

	private Response<ManufacturersDto> response;
	@Autowired
	private ManufacturersRepository manufacturersRepository;
	@Autowired
	private PurchaseOrdersRepository purchaseOrdersRepository;
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

	public ManufacturersBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Manufacturers by using ManufacturersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ManufacturersDto> create(Request<ManufacturersDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Manufacturers-----");

		Response<ManufacturersDto> response = new Response<ManufacturersDto>();
		List<Manufacturers>        items    = new ArrayList<Manufacturers>();
			
		for (ManufacturersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("manufacturerName", dto.getManufacturerName());
			fieldsToVerify.put("contactEmail", dto.getContactEmail());
			fieldsToVerify.put("phone", dto.getPhone());
			fieldsToVerify.put("address", dto.getAddress());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if manufacturers to insert do not exist
			Manufacturers existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("manufacturers manufacturerId -> " + dto.getManufacturerId(), locale));
				response.setHasError(true);
				return response;
			}

				Manufacturers entityToSave = null;
			entityToSave = ManufacturersTransformer.INSTANCE.toEntity(dto);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Manufacturers> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = manufacturersRepository.saveAll((Iterable<Manufacturers>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("manufacturers", locale));
				response.setHasError(true);
				return response;
			}
			List<ManufacturersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ManufacturersTransformer.INSTANCE.toLiteDtos(itemsSaved) : ManufacturersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Manufacturers-----");
		return response;
	}

	/**
	 * update Manufacturers by using ManufacturersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ManufacturersDto> update(Request<ManufacturersDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Manufacturers-----");

		Response<ManufacturersDto> response = new Response<ManufacturersDto>();
		List<Manufacturers>        items    = new ArrayList<Manufacturers>();
			
		for (ManufacturersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("manufacturerId", dto.getManufacturerId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la manufacturers existe
			Manufacturers entityToSave = null;
			entityToSave = manufacturersRepository.findOne(dto.getManufacturerId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("manufacturers manufacturerId -> " + dto.getManufacturerId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getManufacturerName())) {
				entityToSave.setManufacturerName(dto.getManufacturerName());
			}
			if (Utilities.notBlank(dto.getContactEmail())) {
				entityToSave.setContactEmail(dto.getContactEmail());
			}
			if (Utilities.notBlank(dto.getPhone())) {
				entityToSave.setPhone(dto.getPhone());
			}
			if (Utilities.notBlank(dto.getAddress())) {
				entityToSave.setAddress(dto.getAddress());
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
			List<Manufacturers> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = manufacturersRepository.saveAll((Iterable<Manufacturers>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("manufacturers", locale));
				response.setHasError(true);
				return response;
			}
			List<ManufacturersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ManufacturersTransformer.INSTANCE.toLiteDtos(itemsSaved) : ManufacturersTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Manufacturers-----");
		return response;
	}

	/**
	 * delete Manufacturers by using ManufacturersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ManufacturersDto> delete(Request<ManufacturersDto> request, Locale locale)  {
		log.info("----begin delete Manufacturers-----");

		Response<ManufacturersDto> response = new Response<ManufacturersDto>();
		List<Manufacturers>        items    = new ArrayList<Manufacturers>();
			
		for (ManufacturersDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("manufacturerId", dto.getManufacturerId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la manufacturers existe
			Manufacturers existingEntity = null;
			existingEntity = manufacturersRepository.findOne(dto.getManufacturerId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("manufacturers -> " + dto.getManufacturerId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// purchaseOrders
			List<PurchaseOrders> listOfPurchaseOrders = purchaseOrdersRepository.findByManufacturerId(existingEntity.getManufacturerId(), false);
			if (listOfPurchaseOrders != null && !listOfPurchaseOrders.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPurchaseOrders.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// products
			List<Products> listOfProducts = productsRepository.findByManufacturerId(existingEntity.getManufacturerId(), false);
			if (listOfProducts != null && !listOfProducts.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfProducts.size() + ")", locale));
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
			manufacturersRepository.saveAll((Iterable<Manufacturers>) items);

			response.setHasError(false);
		}

		log.info("----end delete Manufacturers-----");
		return response;
	}

	/**
	 * get Manufacturers by using ManufacturersDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ManufacturersDto> getByCriteria(Request<ManufacturersDto> request, Locale locale)  throws Exception {
		log.info("----begin get Manufacturers-----");

		Response<ManufacturersDto> response = new Response<ManufacturersDto>();
		List<Manufacturers> items 			 = manufacturersRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ManufacturersDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ManufacturersTransformer.INSTANCE.toLiteDtos(items) : ManufacturersTransformer.INSTANCE.toDtos(items);

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
			response.setCount(manufacturersRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("manufacturers", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Manufacturers-----");
		return response;
	}

	/**
	 * get full ManufacturersDto by using Manufacturers as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ManufacturersDto getFullInfos(ManufacturersDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
