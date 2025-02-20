                                                    											
/*
 * Java business for entity table client_roles 
 * Created on 2025-02-15 ( Time 03:02:40 )
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
import dev.backend.epharmaApp.dao.entity.ClientRoles;
import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.repository.*;

/**
BUSINESS for table "client_roles"
 * 
 * @author Geo
 *
 */
@Log
@Component
public class ClientRolesBusiness implements IBasicBusiness<Request<ClientRolesDto>, Response<ClientRolesDto>> {

	private Response<ClientRolesDto> response;
	@Autowired
	private ClientRolesRepository clientRolesRepository;
	@Autowired
	private RolesRepository rolesRepository;
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

	public ClientRolesBusiness() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ClientRoles by using ClientRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientRolesDto> create(Request<ClientRolesDto> request, Locale locale)  throws ParseException {
		log.info("----begin create ClientRoles-----");

		Response<ClientRolesDto> response = new Response<ClientRolesDto>();
		List<ClientRoles>        items    = new ArrayList<ClientRoles>();
			
		for (ClientRolesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
//			fieldsToVerify.put("recordStatus", dto.getRecordStatus());
//			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
//			fieldsToVerify.put("deletedBy", dto.getDeletedBy());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if clientRoles to insert do not exist
			ClientRoles existingEntity = null;
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("clientRoles clientId -> " + dto.getClientId(), locale));
				response.setHasError(true);
				return response;
			}

			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("clientRoles roleId -> " + dto.getRoleId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if roles exist
			Roles existingRoles = null;
			if (dto.getRoleId() != null && dto.getRoleId() > 0){
				existingRoles = rolesRepository.findOne(dto.getRoleId(), false);
				if (existingRoles == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("roles roleId -> " + dto.getRoleId(), locale));
					response.setHasError(true);
					return response;
				}
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
				ClientRoles entityToSave = null;
			entityToSave = ClientRolesTransformer.INSTANCE.toEntity(dto, existingRoles, existingClients);
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setIsDeleted(false);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ClientRoles> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = clientRolesRepository.saveAll((Iterable<ClientRoles>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("clientRoles", locale));
				response.setHasError(true);
				return response;
			}
			List<ClientRolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ClientRolesTransformer.INSTANCE.toLiteDtos(itemsSaved) : ClientRolesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end create ClientRoles-----");
		return response;
	}

	/**
	 * update ClientRoles by using ClientRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientRolesDto> update(Request<ClientRolesDto> request, Locale locale)  throws ParseException {
		log.info("----begin update ClientRoles-----");

		Response<ClientRolesDto> response = new Response<ClientRolesDto>();
		List<ClientRoles>        items    = new ArrayList<ClientRoles>();
			
		for (ClientRolesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la clientRoles existe
			ClientRoles entityToSave = null;
			entityToSave = clientRolesRepository.findOneByClientId(dto.getClientId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("clientRoles clientId -> " + dto.getClientId(), locale));
				response.setHasError(true);
				return response;
			}
			entityToSave = clientRolesRepository.findOneByRoleId(dto.getRoleId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("clientRoles roleId -> " + dto.getRoleId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if roles exist
			if (dto.getRoleId() != null && dto.getRoleId() > 0){
				Roles existingRoles = rolesRepository.findOne(dto.getRoleId(), false);
				if (existingRoles == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("roles roleId -> " + dto.getRoleId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setRoles(existingRoles);
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
			List<ClientRoles> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = clientRolesRepository.saveAll((Iterable<ClientRoles>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("clientRoles", locale));
				response.setHasError(true);
				return response;
			}
			List<ClientRolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ClientRolesTransformer.INSTANCE.toLiteDtos(itemsSaved) : ClientRolesTransformer.INSTANCE.toDtos(itemsSaved);

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

		log.info("----end update ClientRoles-----");
		return response;
	}

	/**
	 * delete ClientRoles by using ClientRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientRolesDto> delete(Request<ClientRolesDto> request, Locale locale)  {
		log.info("----begin delete ClientRoles-----");

		Response<ClientRolesDto> response = new Response<ClientRolesDto>();
		List<ClientRoles>        items    = new ArrayList<ClientRoles>();
			
		for (ClientRolesDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("clientId", dto.getClientId());
			fieldsToVerify.put("roleId", dto.getRoleId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la clientRoles existe
			ClientRoles existingEntity = null;
			existingEntity = clientRolesRepository.findOneByClientId(dto.getClientId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("clientRoles -> " + dto.getClientId(), locale));
				response.setHasError(true);
				return response;
			}
			existingEntity = clientRolesRepository.findOneByRoleId(dto.getRoleId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("clientRoles -> " + dto.getRoleId(), locale));
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
			clientRolesRepository.saveAll((Iterable<ClientRoles>) items);

			response.setHasError(false);
		}

		log.info("----end delete ClientRoles-----");
		return response;
	}

	/**
	 * get ClientRoles by using ClientRolesDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ClientRolesDto> getByCriteria(Request<ClientRolesDto> request, Locale locale)  throws Exception {
		log.info("----begin get ClientRoles-----");

		Response<ClientRolesDto> response = new Response<ClientRolesDto>();
		List<ClientRoles> items 			 = clientRolesRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ClientRolesDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ClientRolesTransformer.INSTANCE.toLiteDtos(items) : ClientRolesTransformer.INSTANCE.toDtos(items);

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
			response.setCount(clientRolesRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("clientRoles", locale));
			response.setHasError(false);
			return response;
		}

		log.info("----end get ClientRoles-----");
		return response;
	}

	/**
	 * get full ClientRolesDto by using ClientRoles as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ClientRolesDto getFullInfos(ClientRolesDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
