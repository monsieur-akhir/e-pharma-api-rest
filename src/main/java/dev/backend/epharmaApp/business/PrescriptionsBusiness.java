                                                                														
/*
 * Java business for entity table prescriptions 
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
import dev.backend.epharmaApp.dao.entity.Prescriptions;
import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.*;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "prescriptions"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class PrescriptionsBusiness implements IBasicBusiness<Request<PrescriptionsDto>, Response<PrescriptionsDto>> {

	private Response<PrescriptionsDto> response;
	@Autowired
	private PrescriptionsRepository prescriptionsRepository;
	@Autowired
	private PrescriptionItemsRepository prescriptionItemsRepository;
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

	public PrescriptionsBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Prescriptions by using PrescriptionsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionsDto> create(Request<PrescriptionsDto> request, Locale locale)  throws ParseException {
		log.info("----begin create Prescriptions-----");

		Response<PrescriptionsDto> response = new Response<PrescriptionsDto>();
		List<Prescriptions>        items    = new ArrayList<Prescriptions>();
			
		for (PrescriptionsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("clientId", dto.getClientId());
			fieldsToVerify.put("prescribingDoctor", dto.getPrescribingDoctor());
			fieldsToVerify.put("dateIssued", dto.getDateIssued());
			fieldsToVerify.put("dateExpiration", dto.getDateExpiration());
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if prescriptions to insert do not exist
			Prescriptions existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prescriptions prescriptionId -> " + dto.getPrescriptionId(), locale));
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
				Prescriptions entityToSave = null;
			entityToSave = PrescriptionsTransformer.INSTANCE.toEntity(dto, existingClients);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Prescriptions> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = prescriptionsRepository.saveAll((Iterable<Prescriptions>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prescriptions", locale));
				response.setHasError(true);
				return response;
			}
			List<PrescriptionsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrescriptionsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrescriptionsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create Prescriptions-----");
		return response;
	}

	/**
	 * update Prescriptions by using PrescriptionsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionsDto> update(Request<PrescriptionsDto> request, Locale locale)  throws ParseException {
		log.info("----begin update Prescriptions-----");

		Response<PrescriptionsDto> response = new Response<PrescriptionsDto>();
		List<Prescriptions>        items    = new ArrayList<Prescriptions>();
			
		for (PrescriptionsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("prescriptionId", dto.getPrescriptionId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prescriptions existe
			Prescriptions entityToSave = null;
			entityToSave = prescriptionsRepository.findOne(dto.getPrescriptionId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prescriptions prescriptionId -> " + dto.getPrescriptionId(), locale));
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
			if (Utilities.notBlank(dto.getPrescribingDoctor())) {
				entityToSave.setPrescribingDoctor(dto.getPrescribingDoctor());
			}
			if (dto.getDateIssued() != null) {
				entityToSave.setDateIssued(dto.getDateIssued());
			}
			if (dto.getDateExpiration() != null) {
				entityToSave.setDateExpiration(dto.getDateExpiration());
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
			List<Prescriptions> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = prescriptionsRepository.saveAll((Iterable<Prescriptions>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prescriptions", locale));
				response.setHasError(true);
				return response;
			}
			List<PrescriptionsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrescriptionsTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrescriptionsTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update Prescriptions-----");
		return response;
	}

	/**
	 * delete Prescriptions by using PrescriptionsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionsDto> delete(Request<PrescriptionsDto> request, Locale locale)  {
		log.info("----begin delete Prescriptions-----");

		Response<PrescriptionsDto> response = new Response<PrescriptionsDto>();
		List<Prescriptions>        items    = new ArrayList<Prescriptions>();
			
		for (PrescriptionsDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("prescriptionId", dto.getPrescriptionId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prescriptions existe
			Prescriptions existingEntity = null;
			existingEntity = prescriptionsRepository.findOne(dto.getPrescriptionId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prescriptions -> " + dto.getPrescriptionId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// prescriptionItems
			List<PrescriptionItems> listOfPrescriptionItems = prescriptionItemsRepository.findByPrescriptionId(existingEntity.getPrescriptionId(), false);
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
			prescriptionsRepository.saveAll((Iterable<Prescriptions>) items);

			response.setHasError(false);
		}

		log.info("----end delete Prescriptions-----");
		return response;
	}

	/**
	 * get Prescriptions by using PrescriptionsDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrescriptionsDto> getByCriteria(Request<PrescriptionsDto> request, Locale locale)  throws Exception {
		log.info("----begin get Prescriptions-----");

		Response<PrescriptionsDto> response = new Response<PrescriptionsDto>();
		List<Prescriptions> items 			 = prescriptionsRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PrescriptionsDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrescriptionsTransformer.INSTANCE.toLiteDtos(items) : PrescriptionsTransformer.INSTANCE.toDtos(items);

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
			response.setCount(prescriptionsRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("prescriptions", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get Prescriptions-----");
		return response;
	}

	/**
	 * get full PrescriptionsDto by using Prescriptions as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PrescriptionsDto getFullInfos(PrescriptionsDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
