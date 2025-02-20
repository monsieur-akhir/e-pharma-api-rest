

/*
 * Java transformer for entity table client_roles 
 * Created on 2025-02-15 ( Time 03:02:40 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ClientRoles;
import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.ClientRolesDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "client_roles"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ClientRolesTransformer {

	ClientRolesTransformer INSTANCE = Mappers.getMapper(ClientRolesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.roles.roleId", target="roleId"),
		@Mapping(source="entity.clients.clientId", target="clientId"),
		@Mapping(source="entity.clients.firstName", target="clientsFirstName"),
		@Mapping(source="entity.clients.lastName", target="clientsLastName"),
	})
	ClientRolesDto toDto(ClientRoles entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ClientRolesDto> toDtos(List<ClientRoles> entities) throws ParseException;

    default ClientRolesDto toLiteDto(ClientRoles entity) {
		if (entity == null) {
			return null;
		}
		ClientRolesDto dto = new ClientRolesDto();
		dto.setClientId( entity.getClients().getClientId() );
		dto.setRoleId( entity.getRoles().getRoleId() );
		return dto;
    }

	default List<ClientRolesDto> toLiteDtos(List<ClientRoles> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ClientRolesDto> dtos = new ArrayList<ClientRolesDto>();
		for (ClientRoles entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="roles", target="roles"),
		@Mapping(source="clients", target="clients"),
	})
    ClientRoles toEntity(ClientRolesDto dto, Roles roles, Clients clients) throws ParseException;

    //List<ClientRoles> toEntities(List<ClientRolesDto> dtos) throws ParseException;

}
