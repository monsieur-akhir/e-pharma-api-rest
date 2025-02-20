

/*
 * Java transformer for entity table stock_audit 
 * Created on 2025-02-15 ( Time 03:02:47 )
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
 * TRANSFORMER for table "stock_audit"
 * 
 * @author Geo
 *
 */
@Mapper
public interface StockAuditTransformer {

	StockAuditTransformer INSTANCE = Mappers.getMapper(StockAuditTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.changeDate", dateFormat="dd/MM/yyyy",target="changeDate"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
	})
	StockAuditDto toDto(StockAudit entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<StockAuditDto> toDtos(List<StockAudit> entities) throws ParseException;

    default StockAuditDto toLiteDto(StockAudit entity) {
		if (entity == null) {
			return null;
		}
		StockAuditDto dto = new StockAuditDto();
		dto.setAuditId( entity.getAuditId() );
		return dto;
    }

	default List<StockAuditDto> toLiteDtos(List<StockAudit> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<StockAuditDto> dtos = new ArrayList<StockAuditDto>();
		for (StockAudit entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.auditId", target="auditId"),
		@Mapping(source="dto.pharmacyId", target="pharmacyId"),
		@Mapping(source="dto.productId", target="productId"),
		@Mapping(source="dto.oldQuantity", target="oldQuantity"),
		@Mapping(source="dto.newQuantity", target="newQuantity"),
		@Mapping(source="dto.changeDate", dateFormat="dd/MM/yyyy",target="changeDate"),
		@Mapping(source="dto.recordStatus", target="recordStatus"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.deletedBy", target="deletedBy"),
	})
    StockAudit toEntity(StockAuditDto dto) throws ParseException;

    //List<StockAudit> toEntities(List<StockAuditDto> dtos) throws ParseException;

}
