package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.dao.entity.UserRoles;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.UserRolesDto;
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
public class UserRolesTransformerImpl implements UserRolesTransformer {

    @Override
    public UserRolesDto toDto(UserRoles entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        UserRolesDto userRolesDto = new UserRolesDto();

        if ( entity.getCreatedAt() != null ) {
            userRolesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            userRolesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            userRolesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        userRolesDto.setRoleId( entityRolesRoleId( entity ) );
        userRolesDto.setUserId( entityUsersUserId( entity ) );
        userRolesDto.setUsersLogin( entityUsersLogin( entity ) );
        userRolesDto.setUsersFirstName( entityUsersFirstName( entity ) );
        userRolesDto.setUsersLastName( entityUsersLastName( entity ) );
        userRolesDto.setRecordStatus( entity.getRecordStatus() );
        userRolesDto.setCreatedBy( entity.getCreatedBy() );
        userRolesDto.setUpdatedBy( entity.getUpdatedBy() );
        userRolesDto.setIsDeleted( entity.getIsDeleted() );
        userRolesDto.setDeletedBy( entity.getDeletedBy() );

        return userRolesDto;
    }

    @Override
    public List<UserRolesDto> toDtos(List<UserRoles> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<UserRolesDto> list = new ArrayList<UserRolesDto>( entities.size() );
        for ( UserRoles userRoles : entities ) {
            list.add( toDto( userRoles ) );
        }

        return list;
    }

    @Override
    public UserRoles toEntity(UserRolesDto dto, Roles roles, Users users) throws ParseException {
        if ( dto == null && roles == null && users == null ) {
            return null;
        }

        UserRoles userRoles = new UserRoles();

        if ( dto != null ) {
            userRoles.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                userRoles.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            userRoles.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                userRoles.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            userRoles.setUpdatedBy( dto.getUpdatedBy() );
            userRoles.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                userRoles.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            userRoles.setDeletedBy( dto.getDeletedBy() );
        }
        userRoles.setRoles( roles );
        userRoles.setUsers( users );

        return userRoles;
    }

    private Integer entityRolesRoleId(UserRoles userRoles) {
        if ( userRoles == null ) {
            return null;
        }
        Roles roles = userRoles.getRoles();
        if ( roles == null ) {
            return null;
        }
        Integer roleId = roles.getRoleId();
        if ( roleId == null ) {
            return null;
        }
        return roleId;
    }

    private Integer entityUsersUserId(UserRoles userRoles) {
        if ( userRoles == null ) {
            return null;
        }
        Users users = userRoles.getUsers();
        if ( users == null ) {
            return null;
        }
        Integer userId = users.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String entityUsersLogin(UserRoles userRoles) {
        if ( userRoles == null ) {
            return null;
        }
        Users users = userRoles.getUsers();
        if ( users == null ) {
            return null;
        }
        String login = users.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String entityUsersFirstName(UserRoles userRoles) {
        if ( userRoles == null ) {
            return null;
        }
        Users users = userRoles.getUsers();
        if ( users == null ) {
            return null;
        }
        String firstName = users.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityUsersLastName(UserRoles userRoles) {
        if ( userRoles == null ) {
            return null;
        }
        Users users = userRoles.getUsers();
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
