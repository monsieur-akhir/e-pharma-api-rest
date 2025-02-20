

/*
 * Java transformer for entity table pharmacies 
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
 * TRANSFORMER for table "pharmacies"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PharmaciesTransformer {

	PharmaciesTransformer INSTANCE = Mappers.getMapper(PharmaciesTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
	})
	PharmaciesDto toDto(Pharmacies entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PharmaciesDto> toDtos(List<Pharmacies> entities) throws ParseException;

    default PharmaciesDto toLiteDto(Pharmacies entity) {
		if (entity == null) {
			return null;
		}
		PharmaciesDto dto = new PharmaciesDto();
		dto.setPharmacyId( entity.getPharmacyId() );
		return dto;
    }

	default List<PharmaciesDto> toLiteDtos(List<Pharmacies> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PharmaciesDto> dtos = new ArrayList<PharmaciesDto>();
		for (Pharmacies entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.pharmacyId", target="pharmacyId"),
		@Mapping(source="dto.pharmacyName", target="pharmacyName"),
		@Mapping(source="dto.address", target="address"),
		@Mapping(source="dto.city", target="city"),
		@Mapping(source="dto.country", target="country"),
		@Mapping(source="dto.phone", target="phone"),
		@Mapping(source="dto.location", target="location"),
		@Mapping(source="dto.logo", target="logo"),
		@Mapping(source="dto.autorisation", target="autorisation"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
	})
    Pharmacies toEntity(PharmaciesDto dto) throws ParseException;

    //List<Pharmacies> toEntities(List<PharmaciesDto> dtos) throws ParseException;

}
