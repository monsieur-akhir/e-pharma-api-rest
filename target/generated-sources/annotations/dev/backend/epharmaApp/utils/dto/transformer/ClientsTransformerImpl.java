package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.utils.dto.ClientsDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T13:29:15+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.21 (Oracle Corporation)"
)
public class ClientsTransformerImpl implements ClientsTransformer {

    @Override
    public ClientsDto toDto(Clients entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ClientsDto clientsDto = new ClientsDto();

        if ( entity.getBirthday() != null ) {
            clientsDto.setBirthday( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getBirthday() ) );
        }
        if ( entity.getCreatedAt() != null ) {
            clientsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            clientsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            clientsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        clientsDto.setClientId( entity.getClientId() );
        clientsDto.setLoginClient( entity.getLoginClient() );
        clientsDto.setFirstName( entity.getFirstName() );
        clientsDto.setLastName( entity.getLastName() );
        clientsDto.setEmail( entity.getEmail() );
        clientsDto.setPhone( entity.getPhone() );
        clientsDto.setAddress( entity.getAddress() );
        clientsDto.setCity( entity.getCity() );
        byte[] location = entity.getLocation();
        if ( location != null ) {
            clientsDto.setLocation( Arrays.copyOf( location, location.length ) );
        }
        clientsDto.setPhoto( entity.getPhoto() );
        clientsDto.setRecordStatus( entity.getRecordStatus() );
        clientsDto.setCreatedBy( entity.getCreatedBy() );
        clientsDto.setUpdatedBy( entity.getUpdatedBy() );
        clientsDto.setIsDeleted( entity.getIsDeleted() );
        clientsDto.setDeletedBy( entity.getDeletedBy() );

        return clientsDto;
    }

    @Override
    public List<ClientsDto> toDtos(List<Clients> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ClientsDto> list = new ArrayList<ClientsDto>( entities.size() );
        for ( Clients clients : entities ) {
            list.add( toDto( clients ) );
        }

        return list;
    }

    @Override
    public Clients toEntity(ClientsDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        Clients clients = new Clients();

        clients.setClientId( dto.getClientId() );
        clients.setLoginClient( dto.getLoginClient() );
        clients.setFirstName( dto.getFirstName() );
        clients.setLastName( dto.getLastName() );
        clients.setEmail( dto.getEmail() );
        clients.setPhone( dto.getPhone() );
        clients.setAddress( dto.getAddress() );
        clients.setCity( dto.getCity() );
        byte[] location = dto.getLocation();
        if ( location != null ) {
            clients.setLocation( Arrays.copyOf( location, location.length ) );
        }
        if ( dto.getBirthday() != null ) {
            clients.setBirthday( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getBirthday() ) );
        }
        clients.setPhoto( dto.getPhoto() );
        clients.setRecordStatus( dto.getRecordStatus() );
        if ( dto.getCreatedAt() != null ) {
            clients.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        clients.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getUpdatedAt() != null ) {
            clients.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        clients.setUpdatedBy( dto.getUpdatedBy() );
        clients.setIsDeleted( dto.getIsDeleted() );
        if ( dto.getDeletedAt() != null ) {
            clients.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
        }
        clients.setDeletedBy( dto.getDeletedBy() );

        return clients;
    }
}
