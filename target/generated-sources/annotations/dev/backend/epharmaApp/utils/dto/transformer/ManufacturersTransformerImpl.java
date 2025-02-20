package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Manufacturers;
import dev.backend.epharmaApp.utils.dto.ManufacturersDto;
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
public class ManufacturersTransformerImpl implements ManufacturersTransformer {

    @Override
    public ManufacturersDto toDto(Manufacturers entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ManufacturersDto manufacturersDto = new ManufacturersDto();

        if ( entity.getCreatedAt() != null ) {
            manufacturersDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            manufacturersDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            manufacturersDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        manufacturersDto.setManufacturerId( entity.getManufacturerId() );
        manufacturersDto.setManufacturerName( entity.getManufacturerName() );
        manufacturersDto.setContactEmail( entity.getContactEmail() );
        manufacturersDto.setPhone( entity.getPhone() );
        manufacturersDto.setAddress( entity.getAddress() );
        manufacturersDto.setRecordStatus( entity.getRecordStatus() );
        manufacturersDto.setCreatedBy( entity.getCreatedBy() );
        manufacturersDto.setUpdatedBy( entity.getUpdatedBy() );
        manufacturersDto.setIsDeleted( entity.getIsDeleted() );
        manufacturersDto.setDeletedBy( entity.getDeletedBy() );

        return manufacturersDto;
    }

    @Override
    public List<ManufacturersDto> toDtos(List<Manufacturers> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ManufacturersDto> list = new ArrayList<ManufacturersDto>( entities.size() );
        for ( Manufacturers manufacturers : entities ) {
            list.add( toDto( manufacturers ) );
        }

        return list;
    }

    @Override
    public Manufacturers toEntity(ManufacturersDto dto) throws ParseException {
        if ( dto == null ) {
            return null;
        }

        Manufacturers manufacturers = new Manufacturers();

        manufacturers.setManufacturerId( dto.getManufacturerId() );
        manufacturers.setManufacturerName( dto.getManufacturerName() );
        manufacturers.setContactEmail( dto.getContactEmail() );
        manufacturers.setPhone( dto.getPhone() );
        manufacturers.setAddress( dto.getAddress() );
        manufacturers.setRecordStatus( dto.getRecordStatus() );
        if ( dto.getCreatedAt() != null ) {
            manufacturers.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
        }
        manufacturers.setCreatedBy( dto.getCreatedBy() );
        if ( dto.getUpdatedAt() != null ) {
            manufacturers.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
        }
        manufacturers.setUpdatedBy( dto.getUpdatedBy() );
        manufacturers.setIsDeleted( dto.getIsDeleted() );
        if ( dto.getDeletedAt() != null ) {
            manufacturers.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
        }
        manufacturers.setDeletedBy( dto.getDeletedBy() );

        return manufacturers;
    }
}
