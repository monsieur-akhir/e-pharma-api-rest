

/*
 * Java transformer for entity table delivery_person_profiles 
 * Created on 2025-02-15 ( Time 03:02:41 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.DeliveryPersonProfiles;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.DeliveryPersonProfilesDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "delivery_person_profiles"
 * 
 * @author Geo
 *
 */
@Mapper
public interface DeliveryPersonProfilesTransformer {

	DeliveryPersonProfilesTransformer INSTANCE = Mappers.getMapper(DeliveryPersonProfilesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.registeredDate", dateFormat="dd/MM/yyyy",target="registeredDate"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.users.userId", target="deliveryPersonId"),
		@Mapping(source="entity.users.login", target="usersLogin"),
		@Mapping(source="entity.users.firstName", target="usersFirstName"),
		@Mapping(source="entity.users.lastName", target="usersLastName"),
			@Mapping(target="userId", ignore = true) // Ignorer le mapping automatique depuis entity.userId
	})
	DeliveryPersonProfilesDto toDto(DeliveryPersonProfiles entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<DeliveryPersonProfilesDto> toDtos(List<DeliveryPersonProfiles> entities) throws ParseException;

    default DeliveryPersonProfilesDto toLiteDto(DeliveryPersonProfiles entity) {
		if (entity == null) {
			return null;
		}
		DeliveryPersonProfilesDto dto = new DeliveryPersonProfilesDto();
		dto.setDeliveryPersonId( entity.getDeliveryPersonId() );
		return dto;
    }

	default List<DeliveryPersonProfilesDto> toLiteDtos(List<DeliveryPersonProfiles> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<DeliveryPersonProfilesDto> dtos = new ArrayList<DeliveryPersonProfilesDto>();
		for (DeliveryPersonProfiles entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.status", target="status"),
		@Mapping(source="dto.registeredDate", dateFormat="dd/MM/yyyy",target="registeredDate"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="users", target="users"),
	})
    DeliveryPersonProfiles toEntity(DeliveryPersonProfilesDto dto, Users users) throws ParseException;

    //List<DeliveryPersonProfiles> toEntities(List<DeliveryPersonProfilesDto> dtos) throws ParseException;

}
