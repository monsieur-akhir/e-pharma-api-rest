

/*
 * Java transformer for entity table roles 
 * Created on 2025-02-15 ( Time 03:02:46 )
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
 * TRANSFORMER for table "roles"
 * 
 * @author Geo
 *
 */
@Mapper
public interface RolesTransformer {

	RolesTransformer INSTANCE = Mappers.getMapper(RolesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
	})
	RolesDto toDto(Roles entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<RolesDto> toDtos(List<Roles> entities) throws ParseException;

    default RolesDto toLiteDto(Roles entity) {
		if (entity == null) {
			return null;
		}
		RolesDto dto = new RolesDto();
		dto.setRoleId( entity.getRoleId() );
		return dto;
    }

	default List<RolesDto> toLiteDtos(List<Roles> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<RolesDto> dtos = new ArrayList<RolesDto>();
		for (Roles entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.roleId", target="roleId"),
		@Mapping(source="dto.roleName", target="roleName"),
		@Mapping(source="dto.roleDescription", target="roleDescription"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
	})
    Roles toEntity(RolesDto dto) throws ParseException;

    //List<Roles> toEntities(List<RolesDto> dtos) throws ParseException;

}
