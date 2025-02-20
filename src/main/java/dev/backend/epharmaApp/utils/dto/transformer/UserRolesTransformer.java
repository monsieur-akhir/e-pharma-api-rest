

/*
 * Java transformer for entity table user_roles 
 * Created on 2025-02-15 ( Time 03:02:48 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.dao.entity.UserRoles;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.UserRolesDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "user_roles"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UserRolesTransformer {

	UserRolesTransformer INSTANCE = Mappers.getMapper(UserRolesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.roles.roleId", target="roleId"),
		@Mapping(source="entity.users.userId", target="userId"),
		@Mapping(source="entity.users.login", target="usersLogin"),
		@Mapping(source="entity.users.firstName", target="usersFirstName"),
		@Mapping(source="entity.users.lastName", target="usersLastName"),
	})
	UserRolesDto toDto(UserRoles entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UserRolesDto> toDtos(List<UserRoles> entities) throws ParseException;

    default UserRolesDto toLiteDto(UserRoles entity) {
		if (entity == null) {
			return null;
		}
		UserRolesDto dto = new UserRolesDto();
		dto.setUserId( entity.getUsers().getUserId() );
		dto.setRoleId( entity.getRoles().getRoleId() );
		return dto;
    }

	default List<UserRolesDto> toLiteDtos(List<UserRoles> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UserRolesDto> dtos = new ArrayList<UserRolesDto>();
		for (UserRoles entity : entities) {
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
		@Mapping(source="users", target="users"),
	})
    UserRoles toEntity(UserRolesDto dto, Roles roles, Users users) throws ParseException;

    //List<UserRoles> toEntities(List<UserRolesDto> dtos) throws ParseException;

}
