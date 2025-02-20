package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.UserRatings;
import dev.backend.epharmaApp.dao.entity.Users;
import dev.backend.epharmaApp.utils.dto.UserRatingsDto;
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
public class UserRatingsTransformerImpl implements UserRatingsTransformer {

    @Override
    public UserRatingsDto toDto(UserRatings entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        UserRatingsDto userRatingsDto = new UserRatingsDto();

        if ( entity.getCreatedAt() != null ) {
            userRatingsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            userRatingsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            userRatingsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        userRatingsDto.setRatedUserId( entityUsersUserId( entity ) );
        userRatingsDto.setUsersLogin( entityUsersLogin( entity ) );
        userRatingsDto.setUsersFirstName( entityUsersFirstName( entity ) );
        userRatingsDto.setUsersLastName( entityUsersLastName( entity ) );
        userRatingsDto.setRaterId( entityUsers2UserId( entity ) );
        userRatingsDto.setUsers2Login( entityUsers2Login( entity ) );
        userRatingsDto.setUsers2FirstName( entityUsers2FirstName( entity ) );
        userRatingsDto.setUsers2LastName( entityUsers2LastName( entity ) );
        userRatingsDto.setRatingId( entity.getRatingId() );
        userRatingsDto.setRatingValue( entity.getRatingValue() );
        userRatingsDto.setComment( entity.getComment() );
        userRatingsDto.setRecordStatus( entity.getRecordStatus() );
        userRatingsDto.setCreatedBy( entity.getCreatedBy() );
        userRatingsDto.setUpdatedBy( entity.getUpdatedBy() );
        userRatingsDto.setIsDeleted( entity.getIsDeleted() );
        userRatingsDto.setDeletedBy( entity.getDeletedBy() );

        return userRatingsDto;
    }

    @Override
    public List<UserRatingsDto> toDtos(List<UserRatings> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<UserRatingsDto> list = new ArrayList<UserRatingsDto>( entities.size() );
        for ( UserRatings userRatings : entities ) {
            list.add( toDto( userRatings ) );
        }

        return list;
    }

    @Override
    public UserRatings toEntity(UserRatingsDto dto, Users users, Users users2) throws ParseException {
        if ( dto == null && users == null && users2 == null ) {
            return null;
        }

        UserRatings userRatings = new UserRatings();

        if ( dto != null ) {
            userRatings.setRatingId( dto.getRatingId() );
            userRatings.setRatingValue( dto.getRatingValue() );
            userRatings.setComment( dto.getComment() );
            userRatings.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                userRatings.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            userRatings.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                userRatings.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            userRatings.setUpdatedBy( dto.getUpdatedBy() );
            userRatings.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                userRatings.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            userRatings.setDeletedBy( dto.getDeletedBy() );
        }
        userRatings.setUsers( users );
        userRatings.setUsers2( users2 );

        return userRatings;
    }

    private Integer entityUsersUserId(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users = userRatings.getUsers();
        if ( users == null ) {
            return null;
        }
        Integer userId = users.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String entityUsersLogin(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users = userRatings.getUsers();
        if ( users == null ) {
            return null;
        }
        String login = users.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String entityUsersFirstName(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users = userRatings.getUsers();
        if ( users == null ) {
            return null;
        }
        String firstName = users.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityUsersLastName(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users = userRatings.getUsers();
        if ( users == null ) {
            return null;
        }
        String lastName = users.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private Integer entityUsers2UserId(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users2 = userRatings.getUsers2();
        if ( users2 == null ) {
            return null;
        }
        Integer userId = users2.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private String entityUsers2Login(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users2 = userRatings.getUsers2();
        if ( users2 == null ) {
            return null;
        }
        String login = users2.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String entityUsers2FirstName(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users2 = userRatings.getUsers2();
        if ( users2 == null ) {
            return null;
        }
        String firstName = users2.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityUsers2LastName(UserRatings userRatings) {
        if ( userRatings == null ) {
            return null;
        }
        Users users2 = userRatings.getUsers2();
        if ( users2 == null ) {
            return null;
        }
        String lastName = users2.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }
}
