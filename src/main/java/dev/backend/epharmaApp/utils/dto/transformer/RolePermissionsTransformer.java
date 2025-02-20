

/*
 * Java transformer for entity table role_permissions 
 * Created on 2025-02-15 ( Time 03:02:46 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Permissions;
import dev.backend.epharmaApp.dao.entity.RolePermissions;
import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.RolePermissionsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "role_permissions"
 * 
 * @author Geo
 *
 */
@Mapper
public interface RolePermissionsTransformer {

	RolePermissionsTransformer INSTANCE = Mappers.getMapper(RolePermissionsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.roles.roleId", target="roleId"),
		@Mapping(source="entity.permissions.permissionId", target="permissionId"),
	})
	RolePermissionsDto toDto(RolePermissions entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<RolePermissionsDto> toDtos(List<RolePermissions> entities) throws ParseException;

    default RolePermissionsDto toLiteDto(RolePermissions entity) {
		if (entity == null) {
			return null;
		}
		RolePermissionsDto dto = new RolePermissionsDto();
		dto.setRoleId( entity.getRoles().getRoleId() );
		dto.setPermissionId( entity.getPermissions().getPermissionId() );
		return dto;
    }

	default List<RolePermissionsDto> toLiteDtos(List<RolePermissions> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<RolePermissionsDto> dtos = new ArrayList<RolePermissionsDto>();
		for (RolePermissions entity : entities) {
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
		@Mapping(source="permissions", target="permissions"),
	})
    RolePermissions toEntity(RolePermissionsDto dto, Roles roles, Permissions permissions) throws ParseException;

    //List<RolePermissions> toEntities(List<RolePermissionsDto> dtos) throws ParseException;

}
