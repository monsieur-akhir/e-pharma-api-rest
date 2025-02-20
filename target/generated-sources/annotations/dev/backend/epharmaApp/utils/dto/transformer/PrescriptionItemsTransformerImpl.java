package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.PrescriptionItems;
import dev.backend.epharmaApp.dao.entity.Prescriptions;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.utils.dto.PrescriptionItemsDto;
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
public class PrescriptionItemsTransformerImpl implements PrescriptionItemsTransformer {

    @Override
    public PrescriptionItemsDto toDto(PrescriptionItems entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        PrescriptionItemsDto prescriptionItemsDto = new PrescriptionItemsDto();

        if ( entity.getCreatedAt() != null ) {
            prescriptionItemsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            prescriptionItemsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            prescriptionItemsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        prescriptionItemsDto.setProductId( entityProductsProductId( entity ) );
        prescriptionItemsDto.setPrescriptionId( entityPrescriptionsPrescriptionId( entity ) );
        prescriptionItemsDto.setPrescriptionItemId( entity.getPrescriptionItemId() );
        prescriptionItemsDto.setDosage( entity.getDosage() );
        prescriptionItemsDto.setFrequency( entity.getFrequency() );
        prescriptionItemsDto.setDuration( entity.getDuration() );
        prescriptionItemsDto.setNotes( entity.getNotes() );
        prescriptionItemsDto.setRecordStatus( entity.getRecordStatus() );
        prescriptionItemsDto.setCreatedBy( entity.getCreatedBy() );
        prescriptionItemsDto.setUpdatedBy( entity.getUpdatedBy() );
        prescriptionItemsDto.setIsDeleted( entity.getIsDeleted() );
        prescriptionItemsDto.setDeletedBy( entity.getDeletedBy() );

        return prescriptionItemsDto;
    }

    @Override
    public List<PrescriptionItemsDto> toDtos(List<PrescriptionItems> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<PrescriptionItemsDto> list = new ArrayList<PrescriptionItemsDto>( entities.size() );
        for ( PrescriptionItems prescriptionItems : entities ) {
            list.add( toDto( prescriptionItems ) );
        }

        return list;
    }

    @Override
    public PrescriptionItems toEntity(PrescriptionItemsDto dto, Products products, Prescriptions prescriptions) throws ParseException {
        if ( dto == null && products == null && prescriptions == null ) {
            return null;
        }

        PrescriptionItems prescriptionItems = new PrescriptionItems();

        if ( dto != null ) {
            prescriptionItems.setPrescriptionItemId( dto.getPrescriptionItemId() );
            prescriptionItems.setDosage( dto.getDosage() );
            prescriptionItems.setFrequency( dto.getFrequency() );
            prescriptionItems.setDuration( dto.getDuration() );
            prescriptionItems.setNotes( dto.getNotes() );
            prescriptionItems.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                prescriptionItems.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            prescriptionItems.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                prescriptionItems.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            prescriptionItems.setUpdatedBy( dto.getUpdatedBy() );
            prescriptionItems.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                prescriptionItems.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            prescriptionItems.setDeletedBy( dto.getDeletedBy() );
        }
        prescriptionItems.setProducts( products );
        prescriptionItems.setPrescriptions( prescriptions );

        return prescriptionItems;
    }

    private Integer entityProductsProductId(PrescriptionItems prescriptionItems) {
        if ( prescriptionItems == null ) {
            return null;
        }
        Products products = prescriptionItems.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer productId = products.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private Integer entityPrescriptionsPrescriptionId(PrescriptionItems prescriptionItems) {
        if ( prescriptionItems == null ) {
            return null;
        }
        Prescriptions prescriptions = prescriptionItems.getPrescriptions();
        if ( prescriptions == null ) {
            return null;
        }
        Integer prescriptionId = prescriptions.getPrescriptionId();
        if ( prescriptionId == null ) {
            return null;
        }
        return prescriptionId;
    }
}
