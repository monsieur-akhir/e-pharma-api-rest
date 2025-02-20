package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.StockAlerts;
import dev.backend.epharmaApp.utils.dto.StockAlertsDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T13:29:14+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.21 (Oracle Corporation)"
)
public class StockAlertsTransformerImpl implements StockAlertsTransformer {

    @Override
    public StockAlertsDto toDto(StockAlerts entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        StockAlertsDto stockAlertsDto = new StockAlertsDto();

        if ( entity.getAlertDate() != null ) {
            stockAlertsDto.setAlertDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getAlertDate() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            stockAlertsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            stockAlertsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            stockAlertsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        stockAlertsDto.setProductId( entityProductsProductId( entity ) );
        stockAlertsDto.setPharmacyId( entityPharmaciesPharmacyId( entity ) );
        stockAlertsDto.setAlertId( entity.getAlertId() );
        stockAlertsDto.setCurrentQuantity( entity.getCurrentQuantity() );
        stockAlertsDto.setReorderLevel( entity.getReorderLevel() );
        stockAlertsDto.setAlertSent( entity.getAlertSent() );
        stockAlertsDto.setRecordStatus( entity.getRecordStatus() );
        stockAlertsDto.setCreatedBy( entity.getCreatedBy() );
        stockAlertsDto.setUpdatedBy( entity.getUpdatedBy() );
        stockAlertsDto.setIsDeleted( entity.getIsDeleted() );
        stockAlertsDto.setDeletedBy( entity.getDeletedBy() );

        return stockAlertsDto;
    }

    @Override
    public List<StockAlertsDto> toDtos(List<StockAlerts> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<StockAlertsDto> list = new ArrayList<StockAlertsDto>( entities.size() );
        for ( StockAlerts stockAlerts : entities ) {
            list.add( toDto( stockAlerts ) );
        }

        return list;
    }

    @Override
    public StockAlerts toEntity(StockAlertsDto dto, Products products, Pharmacies pharmacies) throws ParseException {
        if ( dto == null && products == null && pharmacies == null ) {
            return null;
        }

        StockAlerts stockAlerts = new StockAlerts();

        if ( dto != null ) {
            stockAlerts.setAlertId( dto.getAlertId() );
            stockAlerts.setCurrentQuantity( dto.getCurrentQuantity() );
            stockAlerts.setReorderLevel( dto.getReorderLevel() );
            if ( dto.getAlertDate() != null ) {
                stockAlerts.setAlertDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getAlertDate() ) );
            }
            stockAlerts.setAlertSent( dto.getAlertSent() );
            stockAlerts.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                stockAlerts.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            stockAlerts.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                stockAlerts.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            stockAlerts.setUpdatedBy( dto.getUpdatedBy() );
            stockAlerts.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                stockAlerts.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            stockAlerts.setDeletedBy( dto.getDeletedBy() );
        }
        stockAlerts.setProducts( products );
        stockAlerts.setPharmacies( pharmacies );

        return stockAlerts;
    }

    private Integer entityProductsProductId(StockAlerts stockAlerts) {
        if ( stockAlerts == null ) {
            return null;
        }
        Products products = stockAlerts.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer productId = products.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private Integer entityPharmaciesPharmacyId(StockAlerts stockAlerts) {
        if ( stockAlerts == null ) {
            return null;
        }
        Pharmacies pharmacies = stockAlerts.getPharmacies();
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
