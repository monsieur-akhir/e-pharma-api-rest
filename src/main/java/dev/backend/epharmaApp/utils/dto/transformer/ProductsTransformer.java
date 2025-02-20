

/*
 * Java transformer for entity table products 
 * Created on 2025-02-15 ( Time 03:02:45 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Manufacturers;
import dev.backend.epharmaApp.dao.entity.ProductCategories;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.utils.contract.FullTransformerQualifier;
import dev.backend.epharmaApp.utils.dto.ProductsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "products"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ProductsTransformer {

	ProductsTransformer INSTANCE = Mappers.getMapper(ProductsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.productCategories.categoryId", target="categoryId"),
		@Mapping(source="entity.productCategories.categoryName", target="categoryName"),
		@Mapping(source="entity.manufacturers.manufacturerId", target="manufacturerId"),
		@Mapping(source="entity.manufacturers.manufacturerName", target="manufacturerName"),
	})
	ProductsDto toDto(Products entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ProductsDto> toDtos(List<Products> entities) throws ParseException;

    default ProductsDto toLiteDto(Products entity) {
		if (entity == null) {
			return null;
		}
		ProductsDto dto = new ProductsDto();
		dto.setProductId( entity.getProductId() );
		return dto;
    }

	default List<ProductsDto> toLiteDtos(List<Products> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ProductsDto> dtos = new ArrayList<ProductsDto>();
		for (Products entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.productId", target="productId"),
		@Mapping(source="dto.productName", target="productName"),
		@Mapping(source="dto.genericName", target="genericName"),
		@Mapping(source="dto.brandName", target="brandName"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.dosage", target="dosage"),
		@Mapping(source="dto.price", target="price"),
		@Mapping(source="dto.barcode", target="barcode"),
		@Mapping(source="dto.expirationDate", target="expirationDate"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source = "dto.photo", target = "photo"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="productCategories", target="productCategories"),
		@Mapping(source="manufacturers", target="manufacturers"),
	})
    Products toEntity(ProductsDto dto, ProductCategories productCategories, Manufacturers manufacturers) throws ParseException;

    //List<Products> toEntities(List<ProductsDto> dtos) throws ParseException;

}
