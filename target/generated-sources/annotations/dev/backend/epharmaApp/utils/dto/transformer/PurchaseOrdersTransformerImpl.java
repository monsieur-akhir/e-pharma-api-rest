package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Manufacturers;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.PurchaseOrders;
import dev.backend.epharmaApp.utils.dto.PurchaseOrdersDto;
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
public class PurchaseOrdersTransformerImpl implements PurchaseOrdersTransformer {

    @Override
    public PurchaseOrdersDto toDto(PurchaseOrders entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        PurchaseOrdersDto purchaseOrdersDto = new PurchaseOrdersDto();

        if ( entity.getOrderDate() != null ) {
            purchaseOrdersDto.setOrderDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getOrderDate() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            purchaseOrdersDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            purchaseOrdersDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            purchaseOrdersDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        purchaseOrdersDto.setManufacturerId( entityManufacturersManufacturerId( entity ) );
        purchaseOrdersDto.setPharmacyId( entityPharmaciesPharmacyId( entity ) );
        purchaseOrdersDto.setPoId( entity.getPoId() );
        purchaseOrdersDto.setStatus( entity.getStatus() );
        purchaseOrdersDto.setTotalAmount( entity.getTotalAmount() );
        purchaseOrdersDto.setRecordStatus( entity.getRecordStatus() );
        purchaseOrdersDto.setCreatedBy( entity.getCreatedBy() );
        purchaseOrdersDto.setUpdatedBy( entity.getUpdatedBy() );
        purchaseOrdersDto.setIsDeleted( entity.getIsDeleted() );
        purchaseOrdersDto.setDeletedBy( entity.getDeletedBy() );

        return purchaseOrdersDto;
    }

    @Override
    public List<PurchaseOrdersDto> toDtos(List<PurchaseOrders> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<PurchaseOrdersDto> list = new ArrayList<PurchaseOrdersDto>( entities.size() );
        for ( PurchaseOrders purchaseOrders : entities ) {
            list.add( toDto( purchaseOrders ) );
        }

        return list;
    }

    @Override
    public PurchaseOrders toEntity(PurchaseOrdersDto dto, Manufacturers manufacturers, Pharmacies pharmacies) throws ParseException {
        if ( dto == null && manufacturers == null && pharmacies == null ) {
            return null;
        }

        PurchaseOrders purchaseOrders = new PurchaseOrders();

        if ( dto != null ) {
            purchaseOrders.setPoId( dto.getPoId() );
            if ( dto.getOrderDate() != null ) {
                purchaseOrders.setOrderDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getOrderDate() ) );
            }
            purchaseOrders.setStatus( dto.getStatus() );
            purchaseOrders.setTotalAmount( dto.getTotalAmount() );
            purchaseOrders.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                purchaseOrders.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            purchaseOrders.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                purchaseOrders.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            purchaseOrders.setUpdatedBy( dto.getUpdatedBy() );
            purchaseOrders.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                purchaseOrders.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            purchaseOrders.setDeletedBy( dto.getDeletedBy() );
        }
        purchaseOrders.setManufacturers( manufacturers );
        purchaseOrders.setPharmacies( pharmacies );

        return purchaseOrders;
    }

    private Integer entityManufacturersManufacturerId(PurchaseOrders purchaseOrders) {
        if ( purchaseOrders == null ) {
            return null;
        }
        Manufacturers manufacturers = purchaseOrders.getManufacturers();
        if ( manufacturers == null ) {
            return null;
        }
        Integer manufacturerId = manufacturers.getManufacturerId();
        if ( manufacturerId == null ) {
            return null;
        }
        return manufacturerId;
    }

    private Integer entityPharmaciesPharmacyId(PurchaseOrders purchaseOrders) {
        if ( purchaseOrders == null ) {
            return null;
        }
        Pharmacies pharmacies = purchaseOrders.getPharmacies();
        if ( pharmacies == null ) {
            return null;
        }
        Integer pharmacyId = pharmacies.getPharmacyId();
        if ( pharmacyId == null ) {
            return null;
        }
        return pharmacyId;
    }
}
