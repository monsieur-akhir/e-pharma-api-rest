

/*
 * Java transformer for entity table purchase_orders 
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
 * TRANSFORMER for table "purchase_orders"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PurchaseOrdersTransformer {

	PurchaseOrdersTransformer INSTANCE = Mappers.getMapper(PurchaseOrdersTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.orderDate", dateFormat="dd/MM/yyyy",target="orderDate"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.manufacturers.manufacturerId", target="manufacturerId"),
		@Mapping(source="entity.pharmacies.pharmacyId", target="pharmacyId"),
	})
	PurchaseOrdersDto toDto(PurchaseOrders entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PurchaseOrdersDto> toDtos(List<PurchaseOrders> entities) throws ParseException;

    default PurchaseOrdersDto toLiteDto(PurchaseOrders entity) {
		if (entity == null) {
			return null;
		}
		PurchaseOrdersDto dto = new PurchaseOrdersDto();
		dto.setPoId( entity.getPoId() );
		return dto;
    }

	default List<PurchaseOrdersDto> toLiteDtos(List<PurchaseOrders> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PurchaseOrdersDto> dtos = new ArrayList<PurchaseOrdersDto>();
		for (PurchaseOrders entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.poId", target="poId"),
		@Mapping(source="dto.orderDate", dateFormat="dd/MM/yyyy",target="orderDate"),
		@Mapping(source="dto.status", target="status"),
		@Mapping(source="dto.totalAmount", target="totalAmount"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="manufacturers", target="manufacturers"),
		@Mapping(source="pharmacies", target="pharmacies"),
	})
    PurchaseOrders toEntity(PurchaseOrdersDto dto, Manufacturers manufacturers, Pharmacies pharmacies) throws ParseException;

    //List<PurchaseOrders> toEntities(List<PurchaseOrdersDto> dtos) throws ParseException;

}
