

/*
 * Java transformer for entity table purchase_order_items 
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
 * TRANSFORMER for table "purchase_order_items"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PurchaseOrderItemsTransformer {

	PurchaseOrderItemsTransformer INSTANCE = Mappers.getMapper(PurchaseOrderItemsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.products.productId", target="productId"),
		@Mapping(source="entity.purchaseOrders.poId", target="poId"),
	})
	PurchaseOrderItemsDto toDto(PurchaseOrderItems entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PurchaseOrderItemsDto> toDtos(List<PurchaseOrderItems> entities) throws ParseException;

    default PurchaseOrderItemsDto toLiteDto(PurchaseOrderItems entity) {
		if (entity == null) {
			return null;
		}
		PurchaseOrderItemsDto dto = new PurchaseOrderItemsDto();
		dto.setPoItemId( entity.getPoItemId() );
		return dto;
    }

	default List<PurchaseOrderItemsDto> toLiteDtos(List<PurchaseOrderItems> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PurchaseOrderItemsDto> dtos = new ArrayList<PurchaseOrderItemsDto>();
		for (PurchaseOrderItems entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.poItemId", target="poItemId"),
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
		@Mapping(source="products", target="products"),
		@Mapping(source="purchaseOrders", target="purchaseOrders"),
	})
    PurchaseOrderItems toEntity(PurchaseOrderItemsDto dto, Products products, PurchaseOrders purchaseOrders) throws ParseException;

    //List<PurchaseOrderItems> toEntities(List<PurchaseOrderItemsDto> dtos) throws ParseException;

}
