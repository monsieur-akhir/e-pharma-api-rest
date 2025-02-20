package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Deliveries;
import dev.backend.epharmaApp.dao.entity.Orders;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.DeliveriesDto;
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
public class DeliveriesTransformerImpl implements DeliveriesTransformer {

    @Override
    public DeliveriesDto toDto(Deliveries entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        DeliveriesDto deliveriesDto = new DeliveriesDto();

        if ( entity.getExpectedDeliveryDate() != null ) {
            deliveriesDto.setExpectedDeliveryDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getExpectedDeliveryDate() ) );
        }
        if ( entity.getActualDeliveryDate() != null ) {
            deliveriesDto.setActualDeliveryDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getActualDeliveryDate() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            deliveriesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            deliveriesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            deliveriesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        deliveriesDto.setOrderId( entityOrdersOrderId( entity ) );
        deliveriesDto.setPharmacyId( entityPharmaciesPharmacyId( entity ) );
        deliveriesDto.setAssignedTo( entityUsersUserId( entity ) );
        deliveriesDto.setUsersLogin( entityUsersLogin( entity ) );
        deliveriesDto.setUsersFirstName( entityUsersFirstName( entity ) );
        deliveriesDto.setUsersLastName( entityUsersLastName( entity ) );
        deliveriesDto.setDeliveryId( entity.getDeliveryId() );
        deliveriesDto.setDeliveryStatus( entity.getDeliveryStatus() );
        deliveriesDto.setTrackingNumber( entity.getTrackingNumber() );
        deliveriesDto.setDeliveryMethod( entity.getDeliveryMethod() );
        deliveriesDto.setRecordStatus( entity.getRecordStatus() );
        deliveriesDto.setCreatedBy( entity.getCreatedBy() );
        deliveriesDto.setUpdatedBy( entity.getUpdatedBy() );
        deliveriesDto.setIsDeleted( entity.getIsDeleted() );
        deliveriesDto.setDeletedBy( entity.getDeletedBy() );

        return deliveriesDto;
    }

    @Override
    public List<DeliveriesDto> toDtos(List<Deliveries> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<DeliveriesDto> list = new ArrayList<DeliveriesDto>( entities.size() );
        for ( Deliveries deliveries : entities ) {
            list.add( toDto( deliveries ) );
        }

        return list;
    }

    @Override
    public Deliveries toEntity(DeliveriesDto dto, Orders orders, Pharmacies pharmacies, Users users) throws ParseException {
        if ( dto == null && orders == null && pharmacies == null && users == null ) {
            return null;
        }

        Deliveries deliveries = new Deliveries();

        if ( dto != null ) {
            deliveries.setDeliveryId( dto.getDeliveryId() );
            deliveries.setDeliveryStatus( dto.getDeliveryStatus() );
            if ( dto.getExpectedDeliveryDate() != null ) {
                deliveries.setExpectedDeliveryDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getExpectedDeliveryDate() ) );
            }
            if ( dto.getActualDeliveryDate() != null ) {
                deliveries.setActualDeliveryDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getActualDeliveryDate() ) );
            }
            deliveries.setTrackingNumber( dto.getTrackingNumber() );
            deliveries.setDeliveryMethod( dto.getDeliveryMethod() );
            deliveries.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                deliveries.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            deliveries.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                deliveries.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            deliveries.setUpdatedBy( dto.getUpdatedBy() );
            deliveries.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                deliveries.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            deliveries.setDeletedBy( dto.getDeletedBy() );
        }
        deliveries.setOrders( orders );
        deliveries.setPharmacies( pharmacies );
        deliveries.setUsers( users );

        return deliveries;
    }

    private Integer entityOrdersOrderId(Deliveries deliveries) {
        if ( deliveries == null ) {
            return null;
        }
        Orders orders = deliveries.getOrders();
        if ( orders == null ) {
            return null;
        }
        Integer orderId = orders.getOrderId();
        if ( orderId == null ) {
            return null;
        }
        return orderId;
    }

    private Integer entityPharmaciesPharmacyId(Deliveries deliveries) {
        if ( deliveries == null ) {
            return null;
        }
        Pharmacies pharmacies = deliveries.getPharmacies();
        if ( pharmacies == null ) {
            return null;
        }
        Integer pharmacyId = pharmacies.getPharmacyId();
        if ( pharmacyId == null ) {
            return null;
        }
        return pharmacyId;
    }

    private Integer entityUsersUserId(Deliveries deliveries) {
        if ( deliveries == null ) {
            return null;
        }
        Users users = deliveries.getUsers();
        if ( users == null ) {
            return null;
        }
        Integer userId = users.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String entityUsersLogin(Deliveries deliveries) {
        if ( deliveries == null ) {
            return null;
        }
        Users users = deliveries.getUsers();
        if ( users == null ) {
            return null;
        }
        String login = users.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String entityUsersFirstName(Deliveries deliveries) {
        if ( deliveries == null ) {
            return null;
        }
        Users users = deliveries.getUsers();
        if ( users == null ) {
            return null;
        }
        String firstName = users.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityUsersLastName(Deliveries deliveries) {
        if ( deliveries == null ) {
            return null;
        }
        Users users = deliveries.getUsers();
        if ( users == null ) {
            return null;
        }
        String lastName = users.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }
}
