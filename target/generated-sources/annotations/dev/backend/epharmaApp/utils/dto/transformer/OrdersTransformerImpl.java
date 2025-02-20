package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.Orders;
import dev.backend.epharmaApp.utils.dto.OrdersDto;
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
public class OrdersTransformerImpl implements OrdersTransformer {

    @Override
    public OrdersDto toDto(Orders entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        OrdersDto ordersDto = new OrdersDto();

        if ( entity.getOrderDate() != null ) {
            ordersDto.setOrderDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getOrderDate() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            ordersDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            ordersDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            ordersDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        ordersDto.setClientId( entityClientsClientId( entity ) );
        ordersDto.setClientsFirstName( entityClientsFirstName( entity ) );
        ordersDto.setClientsLastName( entityClientsLastName( entity ) );
        ordersDto.setOrderId( entity.getOrderId() );
        ordersDto.setOrderStatus( entity.getOrderStatus() );
        ordersDto.setTotalAmount( entity.getTotalAmount() );
        ordersDto.setPaymentMethod( entity.getPaymentMethod() );
        ordersDto.setRecordStatus( entity.getRecordStatus() );
        ordersDto.setCreatedBy( entity.getCreatedBy() );
        ordersDto.setUpdatedBy( entity.getUpdatedBy() );
        ordersDto.setIsDeleted( entity.getIsDeleted() );
        ordersDto.setDeletedBy( entity.getDeletedBy() );

        return ordersDto;
    }

    @Override
    public List<OrdersDto> toDtos(List<Orders> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<OrdersDto> list = new ArrayList<OrdersDto>( entities.size() );
        for ( Orders orders : entities ) {
            list.add( toDto( orders ) );
        }

        return list;
    }

    @Override
    public Orders toEntity(OrdersDto dto, Clients clients) throws ParseException {
        if ( dto == null && clients == null ) {
            return null;
        }

        Orders orders = new Orders();

        if ( dto != null ) {
            orders.setOrderId( dto.getOrderId() );
            if ( dto.getOrderDate() != null ) {
                orders.setOrderDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getOrderDate() ) );
            }
            orders.setOrderStatus( dto.getOrderStatus() );
            orders.setTotalAmount( dto.getTotalAmount() );
            orders.setPaymentMethod( dto.getPaymentMethod() );
            orders.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                orders.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            orders.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                orders.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            orders.setUpdatedBy( dto.getUpdatedBy() );
            orders.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                orders.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            orders.setDeletedBy( dto.getDeletedBy() );
        }
        orders.setClients( clients );

        return orders;
    }

    private Integer entityClientsClientId(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Clients clients = orders.getClients();
        if ( clients == null ) {
            return null;
        }
        Integer clientId = clients.getClientId();
        if ( clientId == null ) {
            return null;
        }
        return clientId;
    }

    private String entityClientsFirstName(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Clients clients = orders.getClients();
        if ( clients == null ) {
            return null;
        }
        String firstName = clients.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityClientsLastName(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Clients clients = orders.getClients();
        if ( clients == null ) {
            return null;
        }
        String lastName = clients.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }
}
