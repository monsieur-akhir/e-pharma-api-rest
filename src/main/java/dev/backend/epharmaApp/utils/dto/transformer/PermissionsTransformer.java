

/*
 * Java transformer for entity table permissions 
 * Created on 2025-02-15 ( Time 03:02:43 )
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
 * TRANSFORMER for table "permissions"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PermissionsTransformer {

	PermissionsTransformer INSTANCE = Mappers.getMapper(PermissionsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
	})
	PermissionsDto toDto(Permissions entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PermissionsDto> toDtos(List<Permissions> entities) throws ParseException;

    default PermissionsDto toLiteDto(Permissions entity) {
		if (entity == null) {
			return null;
		}
		PermissionsDto dto = new PermissionsDto();
		dto.setPermissionId( entity.getPermissionId() );
		return dto;
    }

	default List<PermissionsDto> toLiteDtos(List<Permissions> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PermissionsDto> dtos = new ArrayList<PermissionsDto>();
		for (Permissions entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.permissionId", target="permissionId"),
		@Mapping(source="dto.permissionName", target="permissionName"),
		@Mapping(source="dto.permissionDescription", target="permissionDescription"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
	})
    Permissions toEntity(PermissionsDto dto) throws ParseException;

    //List<Permissions> toEntities(List<PermissionsDto> dtos) throws ParseException;

}
