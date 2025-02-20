package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.StockAudit;
import dev.backend.epharmaApp.utils.dto.StockAuditDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T13:29:16+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.21 (Oracle Corporation)"
)
public class StockAuditTransformerImpl implements StockAuditTransformer {

    @Override
    public StockAuditDto toDto(StockAudit entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        StockAuditDto stockAuditDto = new StockAuditDto();

        if ( entity.getChangeDate() != null ) {
            stockAuditDto.setChangeDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getChangeDate() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            stockAuditDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            stockAuditDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            stockAuditDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        stockAuditDto.setAuditId( entity.getAuditId() );
        stockAuditDto.setPharmacyId( entity.getPharmacyId() );
        stockAuditDto.setProductId( entity.getProductId() );
        stockAuditDto.setOldQuantity( entity.getOldQuantity() );
        stockAuditDto.setNewQuantity( entity.getNewQuantity() );
        stockAuditDto.setRecordStatus( entity.getRecordStatus() );
        stockAuditDto.setCreatedBy( entity.getCreatedBy() );
        stockAuditDto.setUpdatedBy( entity.getUpdatedBy() );
        stockAuditDto.setIsDeleted( entity.getIsDeleted() );
        stockAuditDto.setDeletedBy( entity.getDeletedBy() );

        return stockAuditDto;
    }

    @Override
    public List<StockAuditDto> toDtos(List<StockAudit> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<StockAuditDto> list = new ArrayList<StockAuditDto>( entities.size() );
        for ( StockAudit stockAudit : entities ) {
            list.add( toDto( stockAudit ) );
        }

        return list;
    }

    @Override
    public StockAudit toEntity(StockAuditDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        StockAudit stockAudit = new StockAudit();

        stockAudit.setAuditId( dto.getAuditId() );
        stockAudit.setPharmacyId( dto.getPharmacyId() );
        stockAudit.setProductId( dto.getProductId() );
        stockAudit.setOldQuantity( dto.getOldQuantity() );
        stockAudit.setNewQuantity( dto.getNewQuantity() );
        if ( dto.getChangeDate() != null ) {
            stockAudit.setChangeDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getChangeDate() ) );
        }
        stockAudit.setRecordStatus( dto.getRecordStatus() );
        if ( dto.getCreatedAt() != null ) {
            stockAudit.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        stockAudit.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getUpdatedAt() != null ) {
            stockAudit.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        stockAudit.setUpdatedBy( dto.getUpdatedBy() );
        stockAudit.setIsDeleted( dto.getIsDeleted() );
        if ( dto.getDeletedAt() != null ) {
            stockAudit.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
        }
        stockAudit.setDeletedBy( dto.getDeletedBy() );

        return stockAudit;
    }
}
