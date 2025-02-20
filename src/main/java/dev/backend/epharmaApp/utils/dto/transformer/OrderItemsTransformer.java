

/*
 * Java transformer for entity table order_items 
 * Created on 2025-02-15 ( Time 03:02:42 )
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
 * TRANSFORMER for table "order_items"
 * 
 * @author Geo
 *
 */
@Mapper
public interface OrderItemsTransformer {

	OrderItemsTransformer INSTANCE = Mappers.getMapper(OrderItemsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.orders.orderId", target="orderId"),
		@Mapping(source="entity.products.productId", target="productId"),
	})
	OrderItemsDto toDto(OrderItems entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<OrderItemsDto> toDtos(List<OrderItems> entities) throws ParseException;

    default OrderItemsDto toLiteDto(OrderItems entity) {
		if (entity == null) {
			return null;
		}
		OrderItemsDto dto = new OrderItemsDto();
		dto.setOrderItemId( entity.getOrderItemId() );
		return dto;
    }

	default List<OrderItemsDto> toLiteDtos(List<OrderItems> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<OrderItemsDto> dtos = new ArrayList<OrderItemsDto>();
		for (OrderItems entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.orderItemId", target="orderItemId"),
		@Mapping(source="dto.quantity", target="quantity"),
		@Mapping(source="dto.unitPrice", target="unitPrice"),
		@Mapping(source="dto.totalPrice", target="totalPrice"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="orders", target="orders"),
		@Mapping(source="products", target="products"),
	})
    OrderItems toEntity(OrderItemsDto dto, Orders orders, Products products) throws ParseException;

    //List<OrderItems> toEntities(List<OrderItemsDto> dtos) throws ParseException;

}
