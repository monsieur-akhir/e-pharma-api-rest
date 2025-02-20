package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.DeliveryPersonProfiles;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.DeliveryPersonProfilesDto;
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
public class DeliveryPersonProfilesTransformerImpl implements DeliveryPersonProfilesTransformer {

    @Override
    public DeliveryPersonProfilesDto toDto(DeliveryPersonProfiles entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        DeliveryPersonProfilesDto deliveryPersonProfilesDto = new DeliveryPersonProfilesDto();

        if ( entity.getRegisteredDate() != null ) {
            deliveryPersonProfilesDto.setRegisteredDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getRegisteredDate() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            deliveryPersonProfilesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            deliveryPersonProfilesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            deliveryPersonProfilesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        deliveryPersonProfilesDto.setDeliveryPersonId( entityUsersUserId( entity ) );
        deliveryPersonProfilesDto.setUsersLogin( entityUsersLogin( entity ) );
        deliveryPersonProfilesDto.setUsersFirstName( entityUsersFirstName( entity ) );
        deliveryPersonProfilesDto.setUsersLastName( entityUsersLastName( entity ) );
        deliveryPersonProfilesDto.setStatus( entity.getStatus() );
        deliveryPersonProfilesDto.setRecordStatus( entity.getRecordStatus() );
        deliveryPersonProfilesDto.setCreatedBy( entity.getCreatedBy() );
        deliveryPersonProfilesDto.setUpdatedBy( entity.getUpdatedBy() );
        deliveryPersonProfilesDto.setIsDeleted( entity.getIsDeleted() );
        deliveryPersonProfilesDto.setDeletedBy( entity.getDeletedBy() );

        return deliveryPersonProfilesDto;
    }

    @Override
    public List<DeliveryPersonProfilesDto> toDtos(List<DeliveryPersonProfiles> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<DeliveryPersonProfilesDto> list = new ArrayList<DeliveryPersonProfilesDto>( entities.size() );
        for ( DeliveryPersonProfiles deliveryPersonProfiles : entities ) {
            list.add( toDto( deliveryPersonProfiles ) );
        }

        return list;
    }

    @Override
    public DeliveryPersonProfiles toEntity(DeliveryPersonProfilesDto dto, Users users) throws ParseException {
        if ( dto == null && users == null ) {
            return null;
        }

        DeliveryPersonProfiles deliveryPersonProfiles = new DeliveryPersonProfiles();

        if ( dto != null ) {
            deliveryPersonProfiles.setStatus( dto.getStatus() );
            if ( dto.getRegisteredDate() != null ) {
                deliveryPersonProfiles.setRegisteredDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getRegisteredDate() ) );
            }
            deliveryPersonProfiles.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                deliveryPersonProfiles.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            deliveryPersonProfiles.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                deliveryPersonProfiles.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            deliveryPersonProfiles.setUpdatedBy( dto.getUpdatedBy() );
            deliveryPersonProfiles.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                deliveryPersonProfiles.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            deliveryPersonProfiles.setDeletedBy( dto.getDeletedBy() );
            deliveryPersonProfiles.setDeliveryPersonId( dto.getDeliveryPersonId() );
        }
        deliveryPersonProfiles.setUsers( users );

        return deliveryPersonProfiles;
    }

    private Integer entityUsersUserId(DeliveryPersonProfiles deliveryPersonProfiles) {
        if ( deliveryPersonProfiles == null ) {
            return null;
        }
        Users users = deliveryPersonProfiles.getUsers();
        if ( users == null ) {
            return null;
        }
        Integer userId = users.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String entityUsersLogin(DeliveryPersonProfiles deliveryPersonProfiles) {
        if ( deliveryPersonProfiles == null ) {
            return null;
        }
        Users users = deliveryPersonProfiles.getUsers();
        if ( users == null ) {
            return null;
        }
        String login = users.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String entityUsersFirstName(DeliveryPersonProfiles deliveryPersonProfiles) {
        if ( deliveryPersonProfiles == null ) {
            return null;
        }
        Users users = deliveryPersonProfiles.getUsers();
        if ( users == null ) {
            return null;
        }
        String firstName = users.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityUsersLastName(DeliveryPersonProfiles deliveryPersonProfiles) {
        if ( deliveryPersonProfiles == null ) {
            return null;
        }
        Users users = deliveryPersonProfiles.getUsers();
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
