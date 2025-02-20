

/*
 * Java transformer for entity table deliveries 
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
 * TRANSFORMER for table "deliveries"
 * 
 * @author Geo
 *
 */
@Mapper
public interface DeliveriesTransformer {

	DeliveriesTransformer INSTANCE = Mappers.getMapper(DeliveriesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.expectedDeliveryDate", dateFormat="dd/MM/yyyy",target="expectedDeliveryDate"),
		@Mapping(source="entity.actualDeliveryDate", dateFormat="dd/MM/yyyy",target="actualDeliveryDate"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.orders.orderId", target="orderId"),
		@Mapping(source="entity.pharmacies.pharmacyId", target="pharmacyId"),
		@Mapping(source="entity.users.userId", target="assignedTo"),
		@Mapping(source="entity.users.login", target="usersLogin"),
		@Mapping(source="entity.users.firstName", target="usersFirstName"),
		@Mapping(source="entity.users.lastName", target="usersLastName"),
	})
	DeliveriesDto toDto(Deliveries entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<DeliveriesDto> toDtos(List<Deliveries> entities) throws ParseException;

    default DeliveriesDto toLiteDto(Deliveries entity) {
		if (entity == null) {
			return null;
		}
		DeliveriesDto dto = new DeliveriesDto();
		dto.setDeliveryId( entity.getDeliveryId() );
		return dto;
    }

	default List<DeliveriesDto> toLiteDtos(List<Deliveries> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<DeliveriesDto> dtos = new ArrayList<DeliveriesDto>();
		for (Deliveries entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.deliveryId", target="deliveryId"),
		@Mapping(source="dto.deliveryStatus", target="deliveryStatus"),
		@Mapping(source="dto.expectedDeliveryDate", dateFormat="dd/MM/yyyy",target="expectedDeliveryDate"),
		@Mapping(source="dto.actualDeliveryDate", dateFormat="dd/MM/yyyy",target="actualDeliveryDate"),
		@Mapping(source="dto.trackingNumber", target="trackingNumber"),
		@Mapping(source="dto.deliveryMethod", target="deliveryMethod"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="orders", target="orders"),
		@Mapping(source="pharmacies", target="pharmacies"),
		@Mapping(source="users", target="users"),
	})
    Deliveries toEntity(DeliveriesDto dto, Orders orders, Pharmacies pharmacies, Users users) throws ParseException;

    //List<Deliveries> toEntities(List<DeliveriesDto> dtos) throws ParseException;

}
