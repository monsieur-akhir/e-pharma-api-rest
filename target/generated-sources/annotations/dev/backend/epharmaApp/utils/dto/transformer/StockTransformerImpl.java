package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.Stock;
import dev.backend.epharmaApp.utils.dto.StockDto;
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
public class StockTransformerImpl implements StockTransformer {

    @Override
    public StockDto toDto(Stock entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        StockDto stockDto = new StockDto();

        if ( entity.getCreatedAt() != null ) {
            stockDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            stockDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            stockDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        stockDto.setProductId( entityProductsProductId( entity ) );
        stockDto.setPharmacyId( entityPharmaciesPharmacyId( entity ) );
        stockDto.setQuantity( entity.getQuantity() );
        stockDto.setReorderLevel( entity.getReorderLevel() );
        stockDto.setRecordStatus( entity.getRecordStatus() );
        stockDto.setCreatedBy( entity.getCreatedBy() );
        stockDto.setUpdatedBy( entity.getUpdatedBy() );
        stockDto.setIsDeleted( entity.getIsDeleted() );
        stockDto.setDeletedBy( entity.getDeletedBy() );

        return stockDto;
    }

    @Override
    public List<StockDto> toDtos(List<Stock> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<StockDto> list = new ArrayList<StockDto>( entities.size() );
        for ( Stock stock : entities ) {
            list.add( toDto( stock ) );
        }

        return list;
    }

    @Override
    public Stock toEntity(StockDto dto, Products products, Pharmacies pharmacies) throws ParseException {
        if ( dto == null && products == null && pharmacies == null ) {
            return null;
        }

        Stock stock = new Stock();

        if ( dto != null ) {
            stock.setQuantity( dto.getQuantity() );
            stock.setReorderLevel( dto.getReorderLevel() );
            stock.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                stock.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            stock.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                stock.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            stock.setUpdatedBy( dto.getUpdatedBy() );
            stock.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                stock.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            stock.setDeletedBy( dto.getDeletedBy() );
        }
        stock.setProducts( products );
        stock.setPharmacies( pharmacies );

        return stock;
    }

    private Integer entityProductsProductId(Stock stock) {
        if ( stock == null ) {
            return null;
        }
        Products products = stock.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer productId = products.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private Integer entityPharmaciesPharmacyId(Stock stock) {
        if ( stock == null ) {
            return null;
        }
        Pharmacies pharmacies = stock.getPharmacies();
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
