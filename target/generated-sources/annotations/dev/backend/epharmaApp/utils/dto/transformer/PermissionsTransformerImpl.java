package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Permissions;
import dev.backend.epharmaApp.utils.dto.PermissionsDto;
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
public class PermissionsTransformerImpl implements PermissionsTransformer {

    @Override
    public PermissionsDto toDto(Permissions entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        PermissionsDto permissionsDto = new PermissionsDto();

        if ( entity.getCreatedAt() != null ) {
            permissionsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            permissionsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            permissionsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        permissionsDto.setPermissionId( entity.getPermissionId() );
        permissionsDto.setPermissionName( entity.getPermissionName() );
        permissionsDto.setPermissionDescription( entity.getPermissionDescription() );
        permissionsDto.setRecordStatus( entity.getRecordStatus() );
        permissionsDto.setCreatedBy( entity.getCreatedBy() );
        permissionsDto.setUpdatedBy( entity.getUpdatedBy() );
        permissionsDto.setIsDeleted( entity.getIsDeleted() );
        permissionsDto.setDeletedBy( entity.getDeletedBy() );

        return permissionsDto;
    }

    @Override
    public List<PermissionsDto> toDtos(List<Permissions> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<PermissionsDto> list = new ArrayList<PermissionsDto>( entities.size() );
        for ( Permissions permissions : entities ) {
            list.add( toDto( permissions ) );
        }

        return list;
    }

    @Override
    public Permissions toEntity(PermissionsDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        Permissions permissions = new Permissions();

        permissions.setPermissionId( dto.getPermissionId() );
        permissions.setPermissionName( dto.getPermissionName() );
        permissions.setPermissionDescription( dto.getPermissionDescription() );
        permissions.setRecordStatus( dto.getRecordStatus() );
        if ( dto.getCreatedAt() != null ) {
            permissions.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        permissions.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getUpdatedAt() != null ) {
            permissions.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        permissions.setUpdatedBy( dto.getUpdatedBy() );
        permissions.setIsDeleted( dto.getIsDeleted() );
        if ( dto.getDeletedAt() != null ) {
            permissions.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
        }
        permissions.setDeletedBy( dto.getDeletedBy() );

        return permissions;
    }
}
