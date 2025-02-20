

/*
 * Java transformer for entity table orders 
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
 * TRANSFORMER for table "orders"
 * 
 * @author Geo
 *
 */
@Mapper
public interface OrdersTransformer {

	OrdersTransformer INSTANCE = Mappers.getMapper(OrdersTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.orderDate", dateFormat="dd/MM/yyyy",target="orderDate"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.clients.clientId", target="clientId"),
		@Mapping(source="entity.clients.firstName", target="clientsFirstName"),
		@Mapping(source="entity.clients.lastName", target="clientsLastName"),
	})
	OrdersDto toDto(Orders entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<OrdersDto> toDtos(List<Orders> entities) throws ParseException;

    default OrdersDto toLiteDto(Orders entity) {
		if (entity == null) {
			return null;
		}
		OrdersDto dto = new OrdersDto();
		dto.setOrderId( entity.getOrderId() );
		return dto;
    }

	default List<OrdersDto> toLiteDtos(List<Orders> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<OrdersDto> dtos = new ArrayList<OrdersDto>();
		for (Orders entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.orderId", target="orderId"),
		@Mapping(source="dto.orderDate", dateFormat="dd/MM/yyyy",target="orderDate"),
		@Mapping(source="dto.orderStatus", target="orderStatus"),
		@Mapping(source="dto.totalAmount", target="totalAmount"),
		@Mapping(source="dto.paymentMethod", target="paymentMethod"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="clients", target="clients"),
	})
    Orders toEntity(OrdersDto dto, Clients clients) throws ParseException;

    //List<Orders> toEntities(List<OrdersDto> dtos) throws ParseException;

}
