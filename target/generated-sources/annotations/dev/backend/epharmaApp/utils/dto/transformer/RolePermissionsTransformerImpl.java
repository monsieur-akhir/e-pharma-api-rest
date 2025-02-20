package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Permissions;
import dev.backend.epharmaApp.dao.entity.RolePermissions;
import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.utils.dto.RolePermissionsDto;
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
public class RolePermissionsTransformerImpl implements RolePermissionsTransformer {

    @Override
    public RolePermissionsDto toDto(RolePermissions entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        RolePermissionsDto rolePermissionsDto = new RolePermissionsDto();

        if ( entity.getCreatedAt() != null ) {
            rolePermissionsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            rolePermissionsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            rolePermissionsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        rolePermissionsDto.setRoleId( entityRolesRoleId( entity ) );
        rolePermissionsDto.setPermissionId( entityPermissionsPermissionId( entity ) );
        rolePermissionsDto.setRecordStatus( entity.getRecordStatus() );
        rolePermissionsDto.setCreatedBy( entity.getCreatedBy() );
        rolePermissionsDto.setUpdatedBy( entity.getUpdatedBy() );
        rolePermissionsDto.setIsDeleted( entity.getIsDeleted() );
        rolePermissionsDto.setDeletedBy( entity.getDeletedBy() );

        return rolePermissionsDto;
    }

    @Override
    public List<RolePermissionsDto> toDtos(List<RolePermissions> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<RolePermissionsDto> list = new ArrayList<RolePermissionsDto>( entities.size() );
        for ( RolePermissions rolePermissions : entities ) {
            list.add( toDto( rolePermissions ) );
        }

        return list;
    }

    @Override
    public RolePermissions toEntity(RolePermissionsDto dto, Roles roles, Permissions permissions) throws ParseException {
        if ( dto == null && roles == null && permissions == null ) {
            return null;
        }

        RolePermissions rolePermissions = new RolePermissions();

        if ( dto != null ) {
            rolePermissions.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                rolePermissions.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            rolePermissions.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                rolePermissions.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            rolePermissions.setUpdatedBy( dto.getUpdatedBy() );
            rolePermissions.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                rolePermissions.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            rolePermissions.setDeletedBy( dto.getDeletedBy() );
        }
        rolePermissions.setRoles( roles );
        rolePermissions.setPermissions( permissions );

        return rolePermissions;
    }

    private Integer entityRolesRoleId(RolePermissions rolePermissions) {
        if ( rolePermissions == null ) {
            return null;
        }
        Roles roles = rolePermissions.getRoles();
        if ( roles == null ) {
            return null;
        }
        Integer roleId = roles.getRoleId();
        if ( roleId == null ) {
            return null;
        }
        return roleId;
    }

    private Integer entityPermissionsPermissionId(RolePermissions rolePermissions) {
        if ( rolePermissions == null ) {
            return null;
        }
        Permissions permissions = rolePermissions.getPermissions();
        if ( permissions == null ) {
            return null;
        }
        Integer permissionId = permissions.getPermissionId();
        if ( permissionId == null ) {
            return null;
        }
        return permissionId;
    }
}
