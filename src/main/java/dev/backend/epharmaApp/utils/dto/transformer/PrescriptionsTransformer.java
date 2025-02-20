

/*
 * Java transformer for entity table prescriptions 
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
 * TRANSFORMER for table "prescriptions"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PrescriptionsTransformer {

	PrescriptionsTransformer INSTANCE = Mappers.getMapper(PrescriptionsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.clients.clientId", target="clientId"),
		@Mapping(source="entity.clients.firstName", target="clientsFirstName"),
		@Mapping(source="entity.clients.lastName", target="clientsLastName"),
	})
	PrescriptionsDto toDto(Prescriptions entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PrescriptionsDto> toDtos(List<Prescriptions> entities) throws ParseException;

    default PrescriptionsDto toLiteDto(Prescriptions entity) {
		if (entity == null) {
			return null;
		}
		PrescriptionsDto dto = new PrescriptionsDto();
		dto.setPrescriptionId( entity.getPrescriptionId() );
		return dto;
    }

	default List<PrescriptionsDto> toLiteDtos(List<Prescriptions> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PrescriptionsDto> dtos = new ArrayList<PrescriptionsDto>();
		for (Prescriptions entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.prescriptionId", target="prescriptionId"),
		@Mapping(source="dto.prescribingDoctor", target="prescribingDoctor"),
		@Mapping(source="dto.dateIssued", target="dateIssued"),
		@Mapping(source="dto.dateExpiration", target="dateExpiration"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
		@Mapping(source="clients", target="clients"),
	})
    Prescriptions toEntity(PrescriptionsDto dto, Clients clients) throws ParseException;

    //List<Prescriptions> toEntities(List<PrescriptionsDto> dtos) throws ParseException;

}
