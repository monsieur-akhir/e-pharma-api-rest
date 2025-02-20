package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.OrderItems;
import dev.backend.epharmaApp.dao.entity.Orders;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.utils.dto.OrderItemsDto;
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
public class OrderItemsTransformerImpl implements OrderItemsTransformer {

    @Override
    public OrderItemsDto toDto(OrderItems entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        OrderItemsDto orderItemsDto = new OrderItemsDto();

        if ( entity.getCreatedAt() != null ) {
            orderItemsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            orderItemsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            orderItemsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        orderItemsDto.setOrderId( entityOrdersOrderId( entity ) );
        orderItemsDto.setProductId( entityProductsProductId( entity ) );
        orderItemsDto.setOrderItemId( entity.getOrderItemId() );
        orderItemsDto.setQuantity( entity.getQuantity() );
        orderItemsDto.setUnitPrice( entity.getUnitPrice() );
        orderItemsDto.setTotalPrice( entity.getTotalPrice() );
        orderItemsDto.setRecordStatus( entity.getRecordStatus() );
        orderItemsDto.setCreatedBy( entity.getCreatedBy() );
        orderItemsDto.setUpdatedBy( entity.getUpdatedBy() );
        orderItemsDto.setIsDeleted( entity.getIsDeleted() );
        orderItemsDto.setDeletedBy( entity.getDeletedBy() );

        return orderItemsDto;
    }

    @Override
    public List<OrderItemsDto> toDtos(List<OrderItems> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<OrderItemsDto> list = new ArrayList<OrderItemsDto>( entities.size() );
        for ( OrderItems orderItems : entities ) {
            list.add( toDto( orderItems ) );
        }

        return list;
    }

    @Override
    public OrderItems toEntity(OrderItemsDto dto, Orders orders, Products products) throws ParseException {
        if ( dto == null && orders == null && products == null ) {
            return null;
        }

        OrderItems orderItems = new OrderItems();

        if ( dto != null ) {
            orderItems.setOrderItemId( dto.getOrderItemId() );
            orderItems.setQuantity( dto.getQuantity() );
            orderItems.setUnitPrice( dto.getUnitPrice() );
            orderItems.setTotalPrice( dto.getTotalPrice() );
            orderItems.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                orderItems.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            orderItems.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                orderItems.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            orderItems.setUpdatedBy( dto.getUpdatedBy() );
            orderItems.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                orderItems.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            orderItems.setDeletedBy( dto.getDeletedBy() );
        }
        orderItems.setOrders( orders );
        orderItems.setProducts( products );

        return orderItems;
    }

    private Integer entityOrdersOrderId(OrderItems orderItems) {
        if ( orderItems == null ) {
            return null;
        }
        Orders orders = orderItems.getOrders();
        if ( orders == null ) {
            return null;
        }
        Integer orderId = orders.getOrderId();
        if ( orderId == null ) {
            return null;
        }
        return orderId;
    }

    private Integer entityProductsProductId(OrderItems orderItems) {
        if ( orderItems == null ) {
            return null;
        }
        Products products = orderItems.getProducts();
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
