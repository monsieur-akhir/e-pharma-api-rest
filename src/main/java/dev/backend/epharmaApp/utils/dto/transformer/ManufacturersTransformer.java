

/*
 * Java transformer for entity table manufacturers 
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
 * TRANSFORMER for table "manufacturers"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ManufacturersTransformer {

	ManufacturersTransformer INSTANCE = Mappers.getMapper(ManufacturersTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
	})
	ManufacturersDto toDto(Manufacturers entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ManufacturersDto> toDtos(List<Manufacturers> entities) throws ParseException;

    default ManufacturersDto toLiteDto(Manufacturers entity) {
		if (entity == null) {
			return null;
		}
		ManufacturersDto dto = new ManufacturersDto();
		dto.setManufacturerId( entity.getManufacturerId() );
		return dto;
    }

	default List<ManufacturersDto> toLiteDtos(List<Manufacturers> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ManufacturersDto> dtos = new ArrayList<ManufacturersDto>();
		for (Manufacturers entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.manufacturerId", target="manufacturerId"),
		@Mapping(source="dto.manufacturerName", target="manufacturerName"),
		@Mapping(source="dto.contactEmail", target="contactEmail"),
		@Mapping(source="dto.phone", target="phone"),
		@Mapping(source="dto.address", target="address"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
	})
    Manufacturers toEntity(ManufacturersDto dto) throws ParseException;

    //List<Manufacturers> toEntities(List<ManufacturersDto> dtos) throws ParseException;

}
