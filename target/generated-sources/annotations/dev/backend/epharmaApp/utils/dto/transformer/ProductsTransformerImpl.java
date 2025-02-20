package dev.backend.epharmaApp.utils.dto.transformer;

import dev.backend.epharmaApp.dao.entity.Manufacturers;
import dev.backend.epharmaApp.dao.entity.ProductCategories;
import dev.backend.epharmaApp.dao.entity.Products;
import dev.backend.epharmaApp.utils.dto.ProductsDto;
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
public class ProductsTransformerImpl implements ProductsTransformer {

    @Override
    public ProductsDto toDto(Products entity) throws ParseException {
        if ( entity == null ) {
            return null;
        }

        ProductsDto productsDto = new ProductsDto();

        if ( entity.getCreatedAt() != null ) {
            productsDto.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getCreatedAt() ) );
        }
        if ( entity.getUpdatedAt() != null ) {
            productsDto.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getUpdatedAt() ) );
        }
        if ( entity.getDeletedAt() != null ) {
            productsDto.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).format( entity.getDeletedAt() ) );
        }
        productsDto.setCategoryId( entityProductCategoriesCategoryId( entity ) );
        productsDto.setCategoryName( entityProductCategoriesCategoryName( entity ) );
        productsDto.setManufacturerId( entityManufacturersManufacturerId( entity ) );
        productsDto.setManufacturerName( entityManufacturersManufacturerName( entity ) );
        productsDto.setProductId( entity.getProductId() );
        productsDto.setProductName( entity.getProductName() );
        productsDto.setGenericName( entity.getGenericName() );
        productsDto.setBrandName( entity.getBrandName() );
        productsDto.setDescription( entity.getDescription() );
        productsDto.setDosage( entity.getDosage() );
        productsDto.setPrice( entity.getPrice() );
        productsDto.setBarcode( entity.getBarcode() );
        productsDto.setExpirationDate( entity.getExpirationDate() );
        productsDto.setRecordStatus( entity.getRecordStatus() );
        productsDto.setPhoto( entity.getPhoto() );
        productsDto.setCreatedBy( entity.getCreatedBy() );
        productsDto.setUpdatedBy( entity.getUpdatedBy() );
        productsDto.setIsDeleted( entity.getIsDeleted() );
        productsDto.setDeletedBy( entity.getDeletedBy() );

        return productsDto;
    }

    @Override
    public List<ProductsDto> toDtos(List<Products> entities) throws ParseException {
        if ( entities == null ) {
            return null;
        }

        List<ProductsDto> list = new ArrayList<ProductsDto>( entities.size() );
        for ( Products products : entities ) {
            list.add( toDto( products ) );
        }

        return list;
    }

    @Override
    public Products toEntity(ProductsDto dto, ProductCategories productCategories, Manufacturers manufacturers) throws ParseException {
        if ( dto == null && productCategories == null && manufacturers == null ) {
            return null;
        }

        Products products = new Products();

        if ( dto != null ) {
            products.setProductId( dto.getProductId() );
            products.setProductName( dto.getProductName() );
            products.setGenericName( dto.getGenericName() );
            products.setBrandName( dto.getBrandName() );
            products.setDescription( dto.getDescription() );
            products.setDosage( dto.getDosage() );
            products.setPrice( dto.getPrice() );
            products.setBarcode( dto.getBarcode() );
            products.setExpirationDate( dto.getExpirationDate() );
            products.setRecordStatus( dto.getRecordStatus() );
            products.setPhoto( dto.getPhoto() );
            if ( dto.getCreatedAt() != null ) {
                products.setCreatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getCreatedAt() ) );
            }
            products.setCreatedBy( dto.getCreatedBy() );
            if ( dto.getUpdatedAt() != null ) {
                products.setUpdatedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getUpdatedAt() ) );
            }
            products.setUpdatedBy( dto.getUpdatedBy() );
            products.setIsDeleted( dto.getIsDeleted() );
            if ( dto.getDeletedAt() != null ) {
                products.setDeletedAt( new SimpleDateFormat( "dd/MM/yyyy" ).parse( dto.getDeletedAt() ) );
            }
            products.setDeletedBy( dto.getDeletedBy() );
        }
        products.setProductCategories( productCategories );
        products.setManufacturers( manufacturers );

        return products;
    }

    private Integer entityProductCategoriesCategoryId(Products products) {
        if ( products == null ) {
            return null;
        }
        ProductCategories productCategories = products.getProductCategories();
        if ( productCategories == null ) {
            return null;
        }
        Integer categoryId = productCategories.getCategoryId();
        if ( categoryId == null ) {
            return null;
        }
        return categoryId;
    }

    private String entityProductCategoriesCategoryName(Products products) {
        if ( products == null ) {
            return null;
        }
        ProductCategories productCategories = products.getProductCategories();
        if ( productCategories == null ) {
            return null;
        }
        String categoryName = productCategories.getCategoryName();
        if ( categoryName == null ) {
            return null;
        }
        return categoryName;
    }

    private Integer entityManufacturersManufacturerId(Products products) {
        if ( products == null ) {
            return null;
        }
        Manufacturers manufacturers = products.getManufacturers();
        if ( manufacturers == null ) {
            return null;
        }
        Integer manufacturerId = manufacturers.getManufacturerId();
        if ( manufacturerId == null ) {
            return null;
        }
        return manufacturerId;
    }

    private String entityManufacturersManufacturerName(Products products) {
        if ( products == null ) {
            return null;
        }
        Manufacturers manufacturers = products.getManufacturers();
        if ( manufacturers == null ) {
            return null;
        }
        String manufacturerName = manufacturers.getManufacturerName();
        if ( manufacturerName == null ) {
            return null;
        }
        return manufacturerName;
    }
}
