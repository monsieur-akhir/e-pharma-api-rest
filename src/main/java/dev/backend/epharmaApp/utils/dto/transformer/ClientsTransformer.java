

/*
 * Java transformer for entity table clients 
 * Created on 2025-02-15 ( Time 03:02:41 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import dev.backend.epharmaApp.utils.contract.*;
import dev.backend.epharmaApp.utils.dto.*;
import dev.backend.epharmaApp.dao.entity.*;


/**
 * TRANSFORMER for table "clients"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ClientsTransformer {

	ClientsTransformer INSTANCE = Mappers.getMapper(ClientsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.birthday", dateFormat="dd/MM/yyyy",target="birthday"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
	})
	ClientsDto toDto(Clients entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ClientsDto> toDtos(List<Clients> entities) throws ParseException;

    default ClientsDto toLiteDto(Clients entity) {
		if (entity == null) {
			return null;
		}
		ClientsDto dto = new ClientsDto();
		dto.setClientId( entity.getClientId() );
		dto.setFirstName( entity.getFirstName() );
		dto.setLastName( entity.getLastName() );
		return dto;
    }

	default List<ClientsDto> toLiteDtos(List<Clients> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ClientsDto> dtos = new ArrayList<ClientsDto>();
		for (Clients entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.clientId", target="clientId"),
		@Mapping(source="dto.loginClient", target="loginClient"),
		@Mapping(source="dto.firstName", target="firstName"),
		@Mapping(source="dto.lastName", target="lastName"),
		@Mapping(source="dto.email", target="email"),
		@Mapping(source="dto.phone", target="phone"),
		@Mapping(source="dto.address", target="address"),
		@Mapping(source="dto.city", target="city"),
		@Mapping(source="dto.location", target="location"),
		@Mapping(source="dto.birthday", dateFormat="dd/MM/yyyy",target="birthday"),
		@Mapping(source="dto.photo", target="photo"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
	})
    Clients toEntity(ClientsDto dto) throws ParseException;

    //List<Clients> toEntities(List<ClientsDto> dtos) throws ParseException;

}
