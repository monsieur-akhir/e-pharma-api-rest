

/*
 * Java transformer for entity table stock_alerts 
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
 * TRANSFORMER for table "stock_alerts"
 * 
 * @author Geo
 *
 */
@Mapper
public interface StockAlertsTransformer {

	StockAlertsTransformer INSTANCE = Mappers.getMapper(StockAlertsTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.alertDate", dateFormat="dd/MM/yyyy",target="alertDate"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.products.productId", target="productId"),
		@Mapping(source="entity.pharmacies.pharmacyId", target="pharmacyId"),
	})
	StockAlertsDto toDto(StockAlerts entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<StockAlertsDto> toDtos(List<StockAlerts> entities) throws ParseException;

    default StockAlertsDto toLiteDto(StockAlerts entity) {
		if (entity == null) {
			return null;
		}
		StockAlertsDto dto = new StockAlertsDto();
		dto.setAlertId( entity.getAlertId() );
		return dto;
    }

	default List<StockAlertsDto> toLiteDtos(List<StockAlerts> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<StockAlertsDto> dtos = new ArrayList<StockAlertsDto>();
		for (StockAlerts entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.alertId", target="alertId"),
		@Mapping(source="dto.currentQuantity", target="currentQuantity"),
		@Mapping(source="dto.reorderLevel", target="reorderLevel"),
		@Mapping(source="dto.alertDate", dateFormat="dd/MM/yyyy",target="alertDate"),
		@Mapping(source="dto.alertSent", target="alertSent"),
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
    StockAlerts toEntity(StockAlertsDto dto, Products products, Pharmacies pharmacies) throws ParseException;

    //List<StockAlerts> toEntities(List<StockAlertsDto> dtos) throws ParseException;

}
