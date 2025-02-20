package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ClientRoles;
import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.Roles;
import dev.backend.epharmaApp.utils.dto.ClientRolesDto;
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
public class ClientRolesTransformerImpl implements ClientRolesTransformer {

    @Override
    public ClientRolesDto toDto(ClientRoles entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ClientRolesDto clientRolesDto = new ClientRolesDto();

        if ( entity.getCreatedAt() != null ) {
            clientRolesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            clientRolesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            clientRolesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        clientRolesDto.setRoleId( entityRolesRoleId( entity ) );
        clientRolesDto.setClientId( entityClientsClientId( entity ) );
        clientRolesDto.setClientsFirstName( entityClientsFirstName( entity ) );
        clientRolesDto.setClientsLastName( entityClientsLastName( entity ) );
        clientRolesDto.setRecordStatus( entity.getRecordStatus() );
        clientRolesDto.setCreatedBy( entity.getCreatedBy() );
        clientRolesDto.setUpdatedBy( entity.getUpdatedBy() );
        clientRolesDto.setIsDeleted( entity.getIsDeleted() );
        clientRolesDto.setDeletedBy( entity.getDeletedBy() );

        return clientRolesDto;
    }

    @Override
    public List<ClientRolesDto> toDtos(List<ClientRoles> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ClientRolesDto> list = new ArrayList<ClientRolesDto>( entities.size() );
        for ( ClientRoles clientRoles : entities ) {
            list.add( toDto( clientRoles ) );
        }

        return list;
    }

    @Override
    public ClientRoles toEntity(ClientRolesDto dto, Roles roles, Clients clients) throws ParseException {
        if ( dto == null && roles == null && clients == null ) {
            return null;
        }

        ClientRoles clientRoles = new ClientRoles();

        if ( dto != null ) {
            clientRoles.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                clientRoles.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            clientRoles.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                clientRoles.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            clientRoles.setUpdatedBy( dto.getUpdatedBy() );
            clientRoles.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                clientRoles.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            clientRoles.setDeletedBy( dto.getDeletedBy() );
        }
        clientRoles.setRoles( roles );
        clientRoles.setClients( clients );

        return clientRoles;
    }

    private Integer entityRolesRoleId(ClientRoles clientRoles) {
        if ( clientRoles == null ) {
            return null;
        }
        Roles roles = clientRoles.getRoles();
        if ( roles == null ) {
            return null;
        }
        Integer roleId = roles.getRoleId();
        if ( roleId == null ) {
            return null;
        }
        return roleId;
    }

    private Integer entityClientsClientId(ClientRoles clientRoles) {
        if ( clientRoles == null ) {
            return null;
        }
        Clients clients = clientRoles.getClients();
        if ( clients == null ) {
            return null;
        }
        Integer clientId = clients.getClientId();
        if ( clientId == null ) {
            return null;
        }
        return clientId;
    }

    private String entityClientsFirstName(ClientRoles clientRoles) {
        if ( clientRoles == null ) {
            return null;
        }
        Clients clients = clientRoles.getClients();
        if ( clients == null ) {
            return null;
        }
        String firstName = clients.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityClientsLastName(ClientRoles clientRoles) {
        if ( clientRoles == null ) {
            return null;
        }
        Clients clients = clientRoles.getClients();
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
