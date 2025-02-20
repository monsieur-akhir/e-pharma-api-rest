

/*
 * Java transformer for entity table notices 
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
 * TRANSFORMER for table "notices"
 * 
 * @author Geo
 *
 */
@Mapper
public interface NoticesTransformer {

	NoticesTransformer INSTANCE = Mappers.getMapper(NoticesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.products.productId", target="productId"),
	})
	NoticesDto toDto(Notices entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<NoticesDto> toDtos(List<Notices> entities) throws ParseException;

    default NoticesDto toLiteDto(Notices entity) {
		if (entity == null) {
			return null;
		}
		NoticesDto dto = new NoticesDto();
		dto.setNoticeId( entity.getNoticeId() );
		return dto;
    }

	default List<NoticesDto> toLiteDtos(List<Notices> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<NoticesDto> dtos = new ArrayList<NoticesDto>();
		for (Notices entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.noticeId", target="noticeId"),
		@Mapping(source="dto.title", target="title"),
		@Mapping(source="dto.content", target="content"),
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
    Notices toEntity(NoticesDto dto, Products products) throws ParseException;

    //List<Notices> toEntities(List<NoticesDto> dtos) throws ParseException;

}
