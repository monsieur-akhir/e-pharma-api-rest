

/*
 * Java transformer for entity table users 
 * Created on 2025-02-15 ( Time 03:02:48 )
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
 * TRANSFORMER for table "users"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UsersTransformer {

	UsersTransformer INSTANCE = Mappers.getMapper(UsersTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.pharmacies.pharmacyId", target="pharmacyId"),
	})
	UsersDto toDto(Users entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UsersDto> toDtos(List<Users> entities) throws ParseException;

    default UsersDto toLiteDto(Users entity) {
		if (entity == null) {
			return null;
		}
		UsersDto dto = new UsersDto();
		dto.setUserId( entity.getUserId() );
		dto.setLogin( entity.getLogin() );
		dto.setFirstName( entity.getFirstName() );
		dto.setLastName( entity.getLastName() );
		return dto;
    }

	default List<UsersDto> toLiteDtos(List<Users> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UsersDto> dtos = new ArrayList<UsersDto>();
		for (Users entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.userId", target="userId"),
		@Mapping(source="dto.login", target="login"),
		@Mapping(source="dto.email", target="email"),
		@Mapping(source="dto.firstName", target="firstName"),
		@Mapping(source="dto.lastName", target="lastName"),
		@Mapping(source="dto.passwordHash", target="passwordHash"),
		@Mapping(source="dto.phone", target="phone"),
		@Mapping(source="dto.address", target="address"),
		@Mapping(source="dto.city", target="city"),
		@Mapping(source="dto.country", target="country"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="pharmacies", target="pharmacies"),
	})
    Users toEntity(UsersDto dto, Pharmacies pharmacies) throws ParseException;

    //List<Users> toEntities(List<UsersDto> dtos) throws ParseException;

}
