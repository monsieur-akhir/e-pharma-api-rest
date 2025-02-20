package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Pharmacies;
import dev.backend.epharmaApp.utils.dto.PharmaciesDto;
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
public class PharmaciesTransformerImpl implements PharmaciesTransformer {

    @Override
    public PharmaciesDto toDto(Pharmacies entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        PharmaciesDto pharmaciesDto = new PharmaciesDto();

        if ( entity.getCreatedAt() != null ) {
            pharmaciesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            pharmaciesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            pharmaciesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        pharmaciesDto.setPharmacyId( entity.getPharmacyId() );
        pharmaciesDto.setPharmacyName( entity.getPharmacyName() );
        pharmaciesDto.setAddress( entity.getAddress() );
        pharmaciesDto.setCity( entity.getCity() );
        pharmaciesDto.setCountry( entity.getCountry() );
        pharmaciesDto.setPhone( entity.getPhone() );
        byte[] location = entity.getLocation();
        if ( location != null ) {
            pharmaciesDto.setLocation( Arrays.copyOf( location, location.length ) );
        }
        pharmaciesDto.setLogo( entity.getLogo() );
        pharmaciesDto.setAutorisation( entity.getAutorisation() );
        pharmaciesDto.setRecordStatus( entity.getRecordStatus() );
        pharmaciesDto.setCreatedBy( entity.getCreatedBy() );
        pharmaciesDto.setUpdatedBy( entity.getUpdatedBy() );
        pharmaciesDto.setIsDeleted( entity.getIsDeleted() );
        pharmaciesDto.setDeletedBy( entity.getDeletedBy() );

        return pharmaciesDto;
    }

    @Override
    public List<PharmaciesDto> toDtos(List<Pharmacies> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<PharmaciesDto> list = new ArrayList<PharmaciesDto>( entities.size() );
        for ( Pharmacies pharmacies : entities ) {
            list.add( toDto( pharmacies ) );
        }

        return list;
    }

    @Override
    public Pharmacies toEntity(PharmaciesDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        Pharmacies pharmacies = new Pharmacies();

        pharmacies.setPharmacyId( dto.getPharmacyId() );
        pharmacies.setPharmacyName( dto.getPharmacyName() );
        pharmacies.setAddress( dto.getAddress() );
        pharmacies.setCity( dto.getCity() );
        pharmacies.setCountry( dto.getCountry() );
        pharmacies.setPhone( dto.getPhone() );
        byte[] location = dto.getLocation();
        if ( location != null ) {
            pharmacies.setLocation( Arrays.copyOf( location, location.length ) );
        }
        pharmacies.setLogo( dto.getLogo() );
        pharmacies.setAutorisation( dto.getAutorisation() );
        pharmacies.setRecordStatus( dto.getRecordStatus() );
        if ( dto.getCreatedAt() != null ) {
            pharmacies.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        pharmacies.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getUpdatedAt() != null ) {
            pharmacies.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        pharmacies.setUpdatedBy( dto.getUpdatedBy() );
        pharmacies.setIsDeleted( dto.getIsDeleted() );
        if ( dto.getDeletedAt() != null ) {
            pharmacies.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
        }
        pharmacies.setDeletedBy( dto.getDeletedBy() );

        return pharmacies;
    }
}
