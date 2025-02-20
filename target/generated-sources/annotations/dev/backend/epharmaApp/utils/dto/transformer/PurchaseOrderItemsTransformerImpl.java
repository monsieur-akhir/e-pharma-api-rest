package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.dao.entity.PurchaseOrderItems;
import dev.backend.epharmaApp.dao.entity.PurchaseOrders;
import dev.backend.epharmaApp.utils.dto.PurchaseOrderItemsDto;
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
public class PurchaseOrderItemsTransformerImpl implements PurchaseOrderItemsTransformer {

    @Override
    public PurchaseOrderItemsDto toDto(PurchaseOrderItems entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        PurchaseOrderItemsDto purchaseOrderItemsDto = new PurchaseOrderItemsDto();

        if ( entity.getCreatedAt() != null ) {
            purchaseOrderItemsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            purchaseOrderItemsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            purchaseOrderItemsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        purchaseOrderItemsDto.setProductId( entityProductsProductId( entity ) );
        purchaseOrderItemsDto.setPoId( entityPurchaseOrdersPoId( entity ) );
        purchaseOrderItemsDto.setPoItemId( entity.getPoItemId() );
        purchaseOrderItemsDto.setQuantity( entity.getQuantity() );
        purchaseOrderItemsDto.setUnitPrice( entity.getUnitPrice() );
        purchaseOrderItemsDto.setTotalPrice( entity.getTotalPrice() );
        purchaseOrderItemsDto.setRecordStatus( entity.getRecordStatus() );
        purchaseOrderItemsDto.setCreatedBy( entity.getCreatedBy() );
        purchaseOrderItemsDto.setUpdatedBy( entity.getUpdatedBy() );
        purchaseOrderItemsDto.setIsDeleted( entity.getIsDeleted() );
        purchaseOrderItemsDto.setDeletedBy( entity.getDeletedBy() );

        return purchaseOrderItemsDto;
    }

    @Override
    public List<PurchaseOrderItemsDto> toDtos(List<PurchaseOrderItems> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<PurchaseOrderItemsDto> list = new ArrayList<PurchaseOrderItemsDto>( entities.size() );
        for ( PurchaseOrderItems purchaseOrderItems : entities ) {
            list.add( toDto( purchaseOrderItems ) );
        }

        return list;
    }

    @Override
    public PurchaseOrderItems toEntity(PurchaseOrderItemsDto dto, Products products, PurchaseOrders purchaseOrders) throws ParseException {
        if ( dto == null && products == null && purchaseOrders == null ) {
            return null;
        }

        PurchaseOrderItems purchaseOrderItems = new PurchaseOrderItems();

        if ( dto != null ) {
            purchaseOrderItems.setPoItemId( dto.getPoItemId() );
            purchaseOrderItems.setQuantity( dto.getQuantity() );
            purchaseOrderItems.setUnitPrice( dto.getUnitPrice() );
            purchaseOrderItems.setTotalPrice( dto.getTotalPrice() );
            purchaseOrderItems.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                purchaseOrderItems.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            purchaseOrderItems.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                purchaseOrderItems.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            purchaseOrderItems.setUpdatedBy( dto.getUpdatedBy() );
            purchaseOrderItems.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                purchaseOrderItems.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            purchaseOrderItems.setDeletedBy( dto.getDeletedBy() );
        }
        purchaseOrderItems.setProducts( products );
        purchaseOrderItems.setPurchaseOrders( purchaseOrders );

        return purchaseOrderItems;
    }

    private Integer entityProductsProductId(PurchaseOrderItems purchaseOrderItems) {
        if ( purchaseOrderItems == null ) {
            return null;
        }
        Products products = purchaseOrderItems.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer productId = products.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private Integer entityPurchaseOrdersPoId(PurchaseOrderItems purchaseOrderItems) {
        if ( purchaseOrderItems == null ) {
            return null;
        }
        PurchaseOrders purchaseOrders = purchaseOrderItems.getPurchaseOrders();
        if ( purchaseOrders == null ) {
            return null;
        }
        Integer poId = purchaseOrders.getPoId();
        if ( poId == null ) {
            return null;
        }
        return poId;
    }
}
