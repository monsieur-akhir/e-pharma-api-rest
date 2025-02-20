package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.utils.dto.RolesDto;
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
public class RolesTransformerImpl implements RolesTransformer {

    @Override
    public RolesDto toDto(Roles entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        RolesDto rolesDto = new RolesDto();

        if ( entity.getCreatedAt() != null ) {
            rolesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            rolesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            rolesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        rolesDto.setRoleId( entity.getRoleId() );
        rolesDto.setRoleName( entity.getRoleName() );
        rolesDto.setRoleDescription( entity.getRoleDescription() );
        rolesDto.setRecordStatus( entity.getRecordStatus() );
        rolesDto.setCreatedBy( entity.getCreatedBy() );
        rolesDto.setUpdatedBy( entity.getUpdatedBy() );
        rolesDto.setIsDeleted( entity.getIsDeleted() );
        rolesDto.setDeletedBy( entity.getDeletedBy() );

        return rolesDto;
    }

    @Override
    public List<RolesDto> toDtos(List<Roles> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<RolesDto> list = new ArrayList<RolesDto>( entities.size() );
        for ( Roles roles : entities ) {
            list.add( toDto( roles ) );
        }

        return list;
    }

    @Override
    public Roles toEntity(RolesDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        Roles roles = new Roles();

        roles.setRoleId( dto.getRoleId() );
        roles.setRoleName( dto.getRoleName() );
        roles.setRoleDescription( dto.getRoleDescription() );
        roles.setRecordStatus( dto.getRecordStatus() );
        if ( dto.getCreatedAt() != null ) {
            roles.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        roles.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getUpdatedAt() != null ) {
            roles.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        roles.setUpdatedBy( dto.getUpdatedBy() );
        roles.setIsDeleted( dto.getIsDeleted() );
        if ( dto.getDeletedAt() != null ) {
            roles.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
        }
        roles.setDeletedBy( dto.getDeletedBy() );

        return roles;
    }
}
