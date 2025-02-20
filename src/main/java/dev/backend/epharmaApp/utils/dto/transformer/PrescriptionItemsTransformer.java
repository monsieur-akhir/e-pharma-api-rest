

/*
 * Java transformer for entity table prescription_items 
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
 * TRANSFORMER for table "prescription_items"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PrescriptionItemsTransformer {

	PrescriptionItemsTransformer INSTANCE = Mappers.getMapper(PrescriptionItemsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.products.productId", target="productId"),
		@Mapping(source="entity.prescriptions.prescriptionId", target="prescriptionId"),
	})
	PrescriptionItemsDto toDto(PrescriptionItems entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PrescriptionItemsDto> toDtos(List<PrescriptionItems> entities) throws ParseException;

    default PrescriptionItemsDto toLiteDto(PrescriptionItems entity) {
		if (entity == null) {
			return null;
		}
		PrescriptionItemsDto dto = new PrescriptionItemsDto();
		dto.setPrescriptionItemId( entity.getPrescriptionItemId() );
		return dto;
    }

	default List<PrescriptionItemsDto> toLiteDtos(List<PrescriptionItems> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PrescriptionItemsDto> dtos = new ArrayList<PrescriptionItemsDto>();
		for (PrescriptionItems entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.prescriptionItemId", target="prescriptionItemId"),
		@Mapping(source="dto.dosage", target="dosage"),
		@Mapping(source="dto.frequency", target="frequency"),
		@Mapping(source="dto.duration", target="duration"),
		@Mapping(source="dto.notes", target="notes"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="products", target="products"),
		@Mapping(source="prescriptions", target="prescriptions"),
	})
    PrescriptionItems toEntity(PrescriptionItemsDto dto, Products products, Prescriptions prescriptions) throws ParseException;

    //List<PrescriptionItems> toEntities(List<PrescriptionItemsDto> dtos) throws ParseException;

}
