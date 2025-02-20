package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ApiUser;
import dev.backend.epharmaApp.utils.dto.ApiUsersDto;
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
public class ApiUserTransformerImpl implements ApiUserTransformer {

    @Override
    public ApiUsersDto toDto(ApiUser entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ApiUsersDto apiUsersDto = new ApiUsersDto();

        if ( entity.getCreatedAt() != null ) {
            apiUsersDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getDateSendCodeOtpAt() != null ) {
            apiUsersDto.setDateSendCodeOtpAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDateSendCodeOtpAt() ) );
        }
        if ( entity.getFirstConnection() != null ) {
            apiUsersDto.setFirstConnection( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getFirstConnection() ) );
        }
        if ( entity.getLastActivityDate() != null ) {
            apiUsersDto.setLastActivityDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getLastActivityDate() ) );
        }
        if ( entity.getLastConnectionDate() != null ) {
            apiUsersDto.setLastConnectionDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getLastConnectionDate() ) );
        }
        if ( entity.getLastLockDate() != null ) {
            apiUsersDto.setLastLockDate( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getLastLockDate() ) );
        }
        if ( entity.getPassCodeCreatedAt() != null ) {
            apiUsersDto.setPassCodeCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getPassCodeCreatedAt() ) );
        }
        if ( entity.getPassCodeExpireAt() != null ) {
            apiUsersDto.setPassCodeExpireAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getPassCodeExpireAt() ) );
        }
        if ( entity.getTokenCreatedAt() != null ) {
            apiUsersDto.setTokenCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getTokenCreatedAt() ) );
        }
        if ( entity.getTokenExpireAt() != null ) {
            apiUsersDto.setTokenExpireAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getTokenExpireAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            apiUsersDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        apiUsersDto.setId( entity.getId() );
        apiUsersDto.setCreatedBy( entity.getCreatedBy() );
        apiUsersDto.setEmail( entity.getEmail() );
        apiUsersDto.setIsActive( entity.getIsActive() );
        apiUsersDto.setIsConnected( entity.getIsConnected() );
        apiUsersDto.setIsDefaultPassword( entity.getIsDefaultPassword() );
        apiUsersDto.setIsDeleted( entity.getIsDeleted() );
        apiUsersDto.setIsLocked( entity.getIsLocked() );
        apiUsersDto.setIsValidPassCode( entity.getIsValidPassCode() );
        apiUsersDto.setIsValidToken( entity.getIsValidToken() );
        apiUsersDto.setLogin( entity.getLogin() );
        apiUsersDto.setLoginAttempts( entity.getLoginAttempts() );
        apiUsersDto.setOtpCode( entity.getOtpCode() );
        apiUsersDto.setPassCode( entity.getPassCode() );
        apiUsersDto.setPassword( entity.getPassword() );
        apiUsersDto.setSearchString( entity.getSearchString() );
        apiUsersDto.setTelephone( entity.getTelephone() );
        apiUsersDto.setToken( entity.getToken() );
        apiUsersDto.setUpdatedBy( entity.getUpdatedBy() );
        apiUsersDto.setRoleId( entity.getRoleId() );
        apiUsersDto.setType( entity.getType() );

        return apiUsersDto;
    }

    @Override
    public List<ApiUsersDto> toDtos(List<ApiUser> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ApiUsersDto> list = new ArrayList<ApiUsersDto>( entities.size() );
        for ( ApiUser apiUser : entities ) {
            list.add( toDto( apiUser ) );
        }

        return list;
    }

    @Override
    public ApiUser toEntity(ApiUsersDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        ApiUser apiUser = new ApiUser();

        apiUser.setId( dto.getId() );
        if ( dto.getCreatedAt() != null ) {
            apiUser.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        apiUser.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getDateSendCodeOtpAt() != null ) {
            apiUser.setDateSendCodeOtpAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDateSendCodeOtpAt() ) );
        }
        apiUser.setEmail( dto.getEmail() );
        if ( dto.getFirstConnection() != null ) {
            apiUser.setFirstConnection( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getFirstConnection() ) );
        }
        apiUser.setIsActive( dto.getIsActive() );
        apiUser.setIsConnected( dto.getIsConnected() );
        apiUser.setIsDefaultPassword( dto.getIsDefaultPassword() );
        apiUser.setIsDeleted( dto.getIsDeleted() );
        apiUser.setIsLocked( dto.getIsLocked() );
        apiUser.setIsValidPassCode( dto.getIsValidPassCode() );
        apiUser.setIsValidToken( dto.getIsValidToken() );
        if ( dto.getLastActivityDate() != null ) {
            apiUser.setLastActivityDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getLastActivityDate() ) );
        }
        if ( dto.getLastConnectionDate() != null ) {
            apiUser.setLastConnectionDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getLastConnectionDate() ) );
        }
        if ( dto.getLastLockDate() != null ) {
            apiUser.setLastLockDate( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getLastLockDate() ) );
        }
        apiUser.setLogin( dto.getLogin() );
        apiUser.setLoginAttempts( dto.getLoginAttempts() );
        apiUser.setOtpCode( dto.getOtpCode() );
        apiUser.setPassCode( dto.getPassCode() );
        if ( dto.getPassCodeCreatedAt() != null ) {
            apiUser.setPassCodeCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getPassCodeCreatedAt() ) );
        }
        if ( dto.getPassCodeExpireAt() != null ) {
            apiUser.setPassCodeExpireAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getPassCodeExpireAt() ) );
        }
        apiUser.setPassword( dto.getPassword() );
        apiUser.setSearchString( dto.getSearchString() );
        apiUser.setTelephone( dto.getTelephone() );
        apiUser.setToken( dto.getToken() );
        if ( dto.getTokenCreatedAt() != null ) {
            apiUser.setTokenCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getTokenCreatedAt() ) );
        }
        if ( dto.getTokenExpireAt() != null ) {
            apiUser.setTokenExpireAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getTokenExpireAt() ) );
        }
        if ( dto.getUpdatedAt() != null ) {
            apiUser.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        apiUser.setUpdatedBy( dto.getUpdatedBy() );
        apiUser.setRoleId( dto.getRoleId() );
        apiUser.setType( dto.getType() );

        return apiUser;
    }
}
