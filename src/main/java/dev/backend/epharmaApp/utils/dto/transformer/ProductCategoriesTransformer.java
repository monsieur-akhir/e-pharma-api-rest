

/*
 * Java transformer for entity table product_categories 
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
 * TRANSFORMER for table "product_categories"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ProductCategoriesTransformer {

	ProductCategoriesTransformer INSTANCE = Mappers.getMapper(ProductCategoriesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.productCategories.categoryId", target="parentCategoryId"),
	})
	ProductCategoriesDto toDto(ProductCategories entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ProductCategoriesDto> toDtos(List<ProductCategories> entities) throws ParseException;

    default ProductCategoriesDto toLiteDto(ProductCategories entity) {
		if (entity == null) {
			return null;
		}
		ProductCategoriesDto dto = new ProductCategoriesDto();
		dto.setCategoryId( entity.getCategoryId() );
		return dto;
    }

	default List<ProductCategoriesDto> toLiteDtos(List<ProductCategories> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ProductCategoriesDto> dtos = new ArrayList<ProductCategoriesDto>();
		for (ProductCategories entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.categoryId", target="categoryId"),
		@Mapping(source="dto.categoryName", target="categoryName"),
		@Mapping(source="dto.categoryDescription", target="categoryDescription"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="productCategories", target="productCategories"),
	})
    ProductCategories toEntity(ProductCategoriesDto dto, ProductCategories productCategories) throws ParseException;

    //List<ProductCategories> toEntities(List<ProductCategoriesDto> dtos) throws ParseException;

}
