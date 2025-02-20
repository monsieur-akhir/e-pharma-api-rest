package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.ProductCategories;
import dev.backend.epharmaApp.utils.dto.ProductCategoriesDto;
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
public class ProductCategoriesTransformerImpl implements ProductCategoriesTransformer {

    @Override
    public ProductCategoriesDto toDto(ProductCategories entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ProductCategoriesDto productCategoriesDto = new ProductCategoriesDto();

        if ( entity.getCreatedAt() != null ) {
            productCategoriesDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            productCategoriesDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            productCategoriesDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        productCategoriesDto.setParentCategoryId( entityProductCategoriesCategoryId( entity ) );
        productCategoriesDto.setCategoryId( entity.getCategoryId() );
        productCategoriesDto.setCategoryName( entity.getCategoryName() );
        productCategoriesDto.setCategoryDescription( entity.getCategoryDescription() );
        productCategoriesDto.setRecordStatus( entity.getRecordStatus() );
        productCategoriesDto.setCreatedBy( entity.getCreatedBy() );
        productCategoriesDto.setUpdatedBy( entity.getUpdatedBy() );
        productCategoriesDto.setIsDeleted( entity.getIsDeleted() );
        productCategoriesDto.setDeletedBy( entity.getDeletedBy() );

        return productCategoriesDto;
    }

    @Override
    public List<ProductCategoriesDto> toDtos(List<ProductCategories> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ProductCategoriesDto> list = new ArrayList<ProductCategoriesDto>( entities.size() );
        for ( ProductCategories productCategories : entities ) {
            list.add( toDto( productCategories ) );
        }

        return list;
    }

    @Override
    public ProductCategories toEntity(ProductCategoriesDto dto, ProductCategories productCategories) throws ParseException {
        if ( dto == null && productCategories == null ) {
            return null;
        }

        ProductCategories productCategories1 = new ProductCategories();

        if ( dto != null ) {
            productCategories1.setCategoryId( dto.getCategoryId() );
            productCategories1.setCategoryName( dto.getCategoryName() );
            productCategories1.setCategoryDescription( dto.getCategoryDescription() );
            productCategories1.setRecordStatus( dto.getRecordStatus() );
            if ( dto.getCreatedAt() != null ) {
                productCategories1.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            productCategories1.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                productCategories1.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            productCategories1.setUpdatedBy( dto.getUpdatedBy() );
            productCategories1.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                productCategories1.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            productCategories1.setDeletedBy( dto.getDeletedBy() );
        }
        productCategories1.setProductCategories( productCategories );

        return productCategories1;
    }

    private Integer entityProductCategoriesCategoryId(ProductCategories productCategories) {
        if ( productCategories == null ) {
            return null;
        }
        ProductCategories productCategories1 = productCategories.getProductCategories();
        if ( productCategories1 == null ) {
            return null;
        }
        Integer categoryId = productCategories1.getCategoryId();
        if ( categoryId == null ) {
            return null;
        }
        return categoryId;
    }
}
