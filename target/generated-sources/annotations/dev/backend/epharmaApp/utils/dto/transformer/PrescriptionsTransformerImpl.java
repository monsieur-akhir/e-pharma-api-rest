package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.Prescriptions;
import dev.backend.epharmaApp.utils.dto.PrescriptionsDto;
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
public class PrescriptionsTransformerImpl implements PrescriptionsTransformer {

    @Override
    public PrescriptionsDto toDto(Prescriptions entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        PrescriptionsDto prescriptionsDto = new PrescriptionsDto();

        if ( entity.getCreatedAt() != null ) {
            prescriptionsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            prescriptionsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            prescriptionsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        prescriptionsDto.setClientId( entityClientsClientId( entity ) );
        prescriptionsDto.setClientsFirstName( entityClientsFirstName( entity ) );
        prescriptionsDto.setClientsLastName( entityClientsLastName( entity ) );
        prescriptionsDto.setPrescriptionId( entity.getPrescriptionId() );
        prescriptionsDto.setPrescribingDoctor( entity.getPrescribingDoctor() );
        prescriptionsDto.setDateIssued( entity.getDateIssued() );
        prescriptionsDto.setDateExpiration( entity.getDateExpiration() );
        prescriptionsDto.setRecordStatus( entity.getRecordStatus() );
        prescriptionsDto.setCreatedBy( entity.getCreatedBy() );
        prescriptionsDto.setUpdatedBy( entity.getUpdatedBy() );
        prescriptionsDto.setIsDeleted( entity.getIsDeleted() );
        prescriptionsDto.setDeletedBy( entity.getDeletedBy() );

        return prescriptionsDto;
    }

    @Override
    public List<PrescriptionsDto> toDtos(List<Prescriptions> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<PrescriptionsDto> list = new ArrayList<PrescriptionsDto>( entities.size() );
        for ( Prescriptions prescriptions : entities ) {
            list.add( toDto( prescriptions ) );
        }

        return list;
    }

    @Override
    public Prescriptions toEntity(PrescriptionsDto dto, Clients clients) throws ParseException {
        if ( dto == null && clients == null ) {
            return null;
        }

        Prescriptions prescriptions = new Prescriptions();

        if ( dto != null ) {
            prescriptions.setPrescriptionId( dto.getPrescriptionId() );
            prescriptions.setPrescribingDoctor( dto.getPrescribingDoctor() );
            prescriptions.setDateIssued( dto.getDateIssued() );
            prescriptions.setDateExpiration( dto.getDateExpiration() );
            prescriptions.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                prescriptions.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            prescriptions.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                prescriptions.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            prescriptions.setUpdatedBy( dto.getUpdatedBy() );
            prescriptions.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                prescriptions.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            prescriptions.setDeletedBy( dto.getDeletedBy() );
        }
        prescriptions.setClients( clients );

        return prescriptions;
    }

    private Integer entityClientsClientId(Prescriptions prescriptions) {
        if ( prescriptions == null ) {
            return null;
        }
        Clients clients = prescriptions.getClients();
        if ( clients == null ) {
            return null;
        }
        Integer clientId = clients.getClientId();
        if ( clientId == null ) {
            return null;
        }
        return clientId;
    }

    private String entityClientsFirstName(Prescriptions prescriptions) {
        if ( prescriptions == null ) {
            return null;
        }
        Clients clients = prescriptions.getClients();
        if ( clients == null ) {
            return null;
        }
        String firstName = clients.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityClientsLastName(Prescriptions prescriptions) {
        if ( prescriptions == null ) {
            return null;
        }
        Clients clients = prescriptions.getClients();
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
