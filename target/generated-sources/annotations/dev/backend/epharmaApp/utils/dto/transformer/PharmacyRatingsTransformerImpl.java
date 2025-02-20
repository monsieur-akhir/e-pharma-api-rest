package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Clients;
import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.dao.entity.PharmacyRatings;
import dev.backend.epharmaApp.utils.dto.PharmacyRatingsDto;
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
public class PharmacyRatingsTransformerImpl implements PharmacyRatingsTransformer {

    @Override
    public PharmacyRatingsDto toDto(PharmacyRatings entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        PharmacyRatingsDto pharmacyRatingsDto = new PharmacyRatingsDto();

        if ( entity.getCreatedAt() != null ) {
            pharmacyRatingsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            pharmacyRatingsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            pharmacyRatingsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        pharmacyRatingsDto.setClientId( entityClientsClientId( entity ) );
        pharmacyRatingsDto.setClientsFirstName( entityClientsFirstName( entity ) );
        pharmacyRatingsDto.setClientsLastName( entityClientsLastName( entity ) );
        pharmacyRatingsDto.setPharmacyId( entityPharmaciesPharmacyId( entity ) );
        pharmacyRatingsDto.setRatingId( entity.getRatingId() );
        pharmacyRatingsDto.setRatingValue( entity.getRatingValue() );
        pharmacyRatingsDto.setComment( entity.getComment() );
        pharmacyRatingsDto.setRecordStatus( entity.getRecordStatus() );
        pharmacyRatingsDto.setCreatedBy( entity.getCreatedBy() );
        pharmacyRatingsDto.setUpdatedBy( entity.getUpdatedBy() );
        pharmacyRatingsDto.setIsDeleted( entity.getIsDeleted() );
        pharmacyRatingsDto.setDeletedBy( entity.getDeletedBy() );

        return pharmacyRatingsDto;
    }

    @Override
    public List<PharmacyRatingsDto> toDtos(List<PharmacyRatings> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<PharmacyRatingsDto> list = new ArrayList<PharmacyRatingsDto>( entities.size() );
        for ( PharmacyRatings pharmacyRatings : entities ) {
            list.add( toDto( pharmacyRatings ) );
        }

        return list;
    }

    @Override
    public PharmacyRatings toEntity(PharmacyRatingsDto dto, Clients clients, Pharmacies pharmacies) throws ParseException {
        if ( dto == null && clients == null && pharmacies == null ) {
            return null;
        }

        PharmacyRatings pharmacyRatings = new PharmacyRatings();

        if ( dto != null ) {
            pharmacyRatings.setRatingId( dto.getRatingId() );
            pharmacyRatings.setRatingValue( dto.getRatingValue() );
            pharmacyRatings.setComment( dto.getComment() );
            pharmacyRatings.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                pharmacyRatings.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            pharmacyRatings.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                pharmacyRatings.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            pharmacyRatings.setUpdatedBy( dto.getUpdatedBy() );
            pharmacyRatings.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                pharmacyRatings.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            pharmacyRatings.setDeletedBy( dto.getDeletedBy() );
        }
        pharmacyRatings.setClients( clients );
        pharmacyRatings.setPharmacies( pharmacies );

        return pharmacyRatings;
    }

    private Integer entityClientsClientId(PharmacyRatings pharmacyRatings) {
        if ( pharmacyRatings == null ) {
            return null;
        }
        Clients clients = pharmacyRatings.getClients();
        if ( clients == null ) {
            return null;
        }
        Integer clientId = clients.getClientId();
        if ( clientId == null ) {
            return null;
        }
        return clientId;
    }

    private String entityClientsFirstName(PharmacyRatings pharmacyRatings) {
        if ( pharmacyRatings == null ) {
            return null;
        }
        Clients clients = pharmacyRatings.getClients();
        if ( clients == null ) {
            return null;
        }
        String firstName = clients.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityClientsLastName(PharmacyRatings pharmacyRatings) {
        if ( pharmacyRatings == null ) {
            return null;
        }
        Clients clients = pharmacyRatings.getClients();
        if ( clients == null ) {
            return null;
        }
        String lastName = clients.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private Integer entityPharmaciesPharmacyId(PharmacyRatings pharmacyRatings) {
        if ( pharmacyRatings == null ) {
            return null;
        }
        Pharmacies pharmacies = pharmacyRatings.getPharmacies();
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
