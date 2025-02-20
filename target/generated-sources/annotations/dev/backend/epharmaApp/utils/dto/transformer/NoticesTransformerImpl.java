package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Notices;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.utils.dto.NoticesDto;
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
public class NoticesTransformerImpl implements NoticesTransformer {

    @Override
    public NoticesDto toDto(Notices entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        NoticesDto noticesDto = new NoticesDto();

        if ( entity.getCreatedAt() != null ) {
            noticesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            noticesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            noticesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        noticesDto.setProductId( entityProductsProductId( entity ) );
        noticesDto.setNoticeId( entity.getNoticeId() );
        noticesDto.setTitle( entity.getTitle() );
        noticesDto.setContent( entity.getContent() );
        noticesDto.setRecordStatus( entity.getRecordStatus() );
        noticesDto.setCreatedBy( entity.getCreatedBy() );
        noticesDto.setUpdatedBy( entity.getUpdatedBy() );
        noticesDto.setIsDeleted( entity.getIsDeleted() );
        noticesDto.setDeletedBy( entity.getDeletedBy() );

        return noticesDto;
    }

    @Override
    public List<NoticesDto> toDtos(List<Notices> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<NoticesDto> list = new ArrayList<NoticesDto>( entities.size() );
        for ( Notices notices : entities ) {
            list.add( toDto( notices ) );
        }

        return list;
    }

    @Override
    public Notices toEntity(NoticesDto dto, Products products) throws ParseException {
        if ( dto == null && products == null ) {
            return null;
        }

        Notices notices = new Notices();

        if ( dto != null ) {
            notices.setNoticeId( dto.getNoticeId() );
            notices.setTitle( dto.getTitle() );
            notices.setContent( dto.getContent() );
            notices.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                notices.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            notices.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                notices.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            notices.setUpdatedBy( dto.getUpdatedBy() );
            notices.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                notices.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            notices.setDeletedBy( dto.getDeletedBy() );
        }
        notices.setProducts( products );

        return notices;
    }

    private Integer entityProductsProductId(Notices notices) {
        if ( notices == null ) {
            return null;
        }
        Products products = notices.getProducts();
        if ( products == null ) {
            return null;
        }
        Integer productId = products.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }
}
