

/*
 * Java transformer for entity table stock 
 * Created on 2025-02-15 ( Time 03:02:47 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.Stock;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.StockDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "stock"
 * 
 * @author Geo
 *
 */
@Mapper
public interface StockTransformer {

	StockTransformer INSTANCE = Mappers.getMapper(StockTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.products.productId", target="productId"),
		@Mapping(source="entity.pharmacies.pharmacyId", target="pharmacyId"),
	})
	StockDto toDto(Stock entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<StockDto> toDtos(List<Stock> entities) throws ParseException;

    default StockDto toLiteDto(Stock entity) {
		if (entity == null) {
			return null;
		}
		StockDto dto = new StockDto();
		dto.setPharmacyId( entity.getPharmacies().getPharmacyId() );
		dto.setProductId( entity.getProducts().getProductId() );
		return dto;
    }

	default List<StockDto> toLiteDtos(List<Stock> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<StockDto> dtos = new ArrayList<StockDto>();
		for (Stock entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.quantity", target="quantity"),
		@Mapping(source="dto.reorderLevel", target="reorderLevel"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="products", target="products"),
		@Mapping(source="pharmacies", target="pharmacies"),
	})
    Stock toEntity(StockDto dto, Products products, Pharmacies pharmacies) throws ParseException;

    //List<Stock> toEntities(List<StockDto> dtos) throws ParseException;

}
