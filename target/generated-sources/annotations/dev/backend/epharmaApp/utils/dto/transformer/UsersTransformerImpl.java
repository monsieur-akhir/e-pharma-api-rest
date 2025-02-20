package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.UsersDto;
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
public class UsersTransformerImpl implements UsersTransformer {

    @Override
    public UsersDto toDto(Users entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        if ( entity.getCreatedAt() != null ) {
            usersDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            usersDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            usersDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        usersDto.setPharmacyId( entityPharmaciesPharmacyId( entity ) );
        usersDto.setUserId( entity.getUserId() );
        usersDto.setLogin( entity.getLogin() );
        usersDto.setEmail( entity.getEmail() );
        usersDto.setFirstName( entity.getFirstName() );
        usersDto.setLastName( entity.getLastName() );
        usersDto.setPasswordHash( entity.getPasswordHash() );
        usersDto.setPhone( entity.getPhone() );
        usersDto.setAddress( entity.getAddress() );
        usersDto.setCity( entity.getCity() );
        usersDto.setCountry( entity.getCountry() );
        usersDto.setRecordStatus( entity.getRecordStatus() );
        usersDto.setCreatedBy( entity.getCreatedBy() );
        usersDto.setUpdatedBy( entity.getUpdatedBy() );
        usersDto.setIsDeleted( entity.getIsDeleted() );
        usersDto.setDeletedBy( entity.getDeletedBy() );

        return usersDto;
    }

    @Override
    public List<UsersDto> toDtos(List<Users> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<UsersDto> list = new ArrayList<UsersDto>( entities.size() );
        for ( Users users : entities ) {
            list.add( toDto( users ) );
        }

        return list;
    }

    @Override
    public Users toEntity(UsersDto dto, Pharmacies pharmacies) throws ParseException {
        if ( dto == null && pharmacies == null ) {
            return null;
        }

        Users users = new Users();

        if ( dto != null ) {
            users.setUserId( dto.getUserId() );
            users.setLogin( dto.getLogin() );
            users.setEmail( dto.getEmail() );
            users.setFirstName( dto.getFirstName() );
            users.setLastName( dto.getLastName() );
            users.setPasswordHash( dto.getPasswordHash() );
            users.setPhone( dto.getPhone() );
            users.setAddress( dto.getAddress() );
            users.setCity( dto.getCity() );
            users.setCountry( dto.getCountry() );
            users.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                users.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            users.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                users.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            users.setUpdatedBy( dto.getUpdatedBy() );
            users.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                users.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            users.setDeletedBy( dto.getDeletedBy() );
        }
        users.setPharmacies( pharmacies );

        return users;
    }

    private Integer entityPharmaciesPharmacyId(Users users) {
        if ( users == null ) {
            return null;
        }
        Pharmacies pharmacies = users.getPharmacies();
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
