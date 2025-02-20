package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ProductMovements;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.utils.dto.ProductMovementsDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T13:29:15+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.21 (Oracle Corporation)"
)
public class ProductMovementsTransformerImpl implements ProductMovementsTransformer {

    @Override
    public ProductMovementsDto toDto(ProductMovements entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ProductMovementsDto productMovementsDto = new ProductMovementsDto();

        if ( entity.getMovementDate() != null ) {
            productMovementsDto.setMovementDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getMovementDate() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            productMovementsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            productMovementsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            productMovementsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        productMovementsDto.setProductId( entityProductsProductId( entity ) );
        productMovementsDto.setMovementId( entity.getMovementId() );
        productMovementsDto.setFromEntity( entity.getFromEntity() );
        productMovementsDto.setToEntity( entity.getToEntity() );
        productMovementsDto.setQuantity( entity.getQuantity() );
        productMovementsDto.setRemarks( entity.getRemarks() );
        productMovementsDto.setRecordStatus( entity.getRecordStatus() );
        productMovementsDto.setCreatedBy( entity.getCreatedBy() );
        productMovementsDto.setUpdatedBy( entity.getUpdatedBy() );
        productMovementsDto.setIsDeleted( entity.getIsDeleted() );
        productMovementsDto.setDeletedBy( entity.getDeletedBy() );

        return productMovementsDto;
    }

    @Override
    public List<ProductMovementsDto> toDtos(List<ProductMovements> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ProductMovementsDto> list = new ArrayList<ProductMovementsDto>( entities.size() );
        for ( ProductMovements productMovements : entities ) {
            list.add( toDto( productMovements ) );
        }

        return list;
    }

    @Override
    public ProductMovements toEntity(ProductMovementsDto dto, Products products) throws ParseException {
        if ( dto == null && products == null ) {
            return null;
        }

        ProductMovements productMovements = new ProductMovements();

        if ( dto != null ) {
            productMovements.setMovementId( dto.getMovementId() );
            productMovements.setFromEntity( dto.getFromEntity() );
            productMovements.setToEntity( dto.getToEntity() );
            if ( dto.getMovementDate() != null ) {
                productMovements.setMovementDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getMovementDate() ) );
            }
            productMovements.setQuantity( dto.getQuantity() );
            productMovements.setRemarks( dto.getRemarks() );
            productMovements.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                productMovements.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            productMovements.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                productMovements.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            productMovements.setUpdatedBy( dto.getUpdatedBy() );
            productMovements.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                productMovements.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            productMovements.setDeletedBy( dto.getDeletedBy() );
        }
        productMovements.setProducts( products );

        return productMovements;
    }

    private Integer entityProductsProductId(ProductMovements productMovements) {
        if ( productMovements == null ) {
            return null;
        }
        Products products = productMovements.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer productId = products.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }
}
