

/*
 * Java transformer for entity table product_movements 
 * Created on 2025-02-15 ( Time 03:02:44 )
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
 * TRANSFORMER for table "product_movements"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ProductMovementsTransformer {

	ProductMovementsTransformer INSTANCE = Mappers.getMapper(ProductMovementsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.movementDate", dateFormat="dd/MM/yyyy",target="movementDate"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.products.productId", target="productId"),
	})
	ProductMovementsDto toDto(ProductMovements entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ProductMovementsDto> toDtos(List<ProductMovements> entities) throws ParseException;

    default ProductMovementsDto toLiteDto(ProductMovements entity) {
		if (entity == null) {
			return null;
		}
		ProductMovementsDto dto = new ProductMovementsDto();
		dto.setMovementId( entity.getMovementId() );
		return dto;
    }

	default List<ProductMovementsDto> toLiteDtos(List<ProductMovements> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ProductMovementsDto> dtos = new ArrayList<ProductMovementsDto>();
		for (ProductMovements entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.movementId", target="movementId"),
		@Mapping(source="dto.fromEntity", target="fromEntity"),
		@Mapping(source="dto.toEntity", target="toEntity"),
		@Mapping(source="dto.movementDate", dateFormat="dd/MM/yyyy",target="movementDate"),
		@Mapping(source="dto.quantity", target="quantity"),
		@Mapping(source="dto.remarks", target="remarks"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="products", target="products"),
	})
    ProductMovements toEntity(ProductMovementsDto dto, Products products) throws ParseException;

    //List<ProductMovements> toEntities(List<ProductMovementsDto> dtos) throws ParseException;

}
