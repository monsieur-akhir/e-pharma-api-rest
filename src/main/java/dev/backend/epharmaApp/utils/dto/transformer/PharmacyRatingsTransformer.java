

/*
 * Java transformer for entity table pharmacy_ratings 
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
 * TRANSFORMER for table "pharmacy_ratings"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PharmacyRatingsTransformer {

	PharmacyRatingsTransformer INSTANCE = Mappers.getMapper(PharmacyRatingsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.clients.clientId", target="clientId"),
		@Mapping(source="entity.clients.firstName", target="clientsFirstName"),
		@Mapping(source="entity.clients.lastName", target="clientsLastName"),
		@Mapping(source="entity.pharmacies.pharmacyId", target="pharmacyId"),
	})
	PharmacyRatingsDto toDto(PharmacyRatings entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PharmacyRatingsDto> toDtos(List<PharmacyRatings> entities) throws ParseException;

    default PharmacyRatingsDto toLiteDto(PharmacyRatings entity) {
		if (entity == null) {
			return null;
		}
		PharmacyRatingsDto dto = new PharmacyRatingsDto();
		dto.setRatingId( entity.getRatingId() );
		return dto;
    }

	default List<PharmacyRatingsDto> toLiteDtos(List<PharmacyRatings> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PharmacyRatingsDto> dtos = new ArrayList<PharmacyRatingsDto>();
		for (PharmacyRatings entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.ratingId", target="ratingId"),
		@Mapping(source="dto.ratingValue", target="ratingValue"),
		@Mapping(source="dto.comment", target="comment"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="clients", target="clients"),
		@Mapping(source="pharmacies", target="pharmacies"),
	})
    PharmacyRatings toEntity(PharmacyRatingsDto dto, Clients clients, Pharmacies pharmacies) throws ParseException;

    //List<PharmacyRatings> toEntities(List<PharmacyRatingsDto> dtos) throws ParseException;

}
