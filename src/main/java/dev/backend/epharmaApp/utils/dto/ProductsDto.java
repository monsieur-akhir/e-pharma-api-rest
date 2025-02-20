
/*
 * Java dto for entity table products 
 * Created on 2025-02-15 ( Time 03:02:45 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.backend.epharmaApp.utils.contract.SearchParam;
import dev.backend.epharmaApp.utils.dto.customize._ProductsDto;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * DTO for table "products"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class ProductsDto extends _ProductsDto implements Cloneable{

    private Integer    productId            ; // Primary Key

    private String     productName          ;
    private String     genericName          ;
    private String     brandName            ;
    private String     description          ;
    private Integer    categoryId           ;
    private String     dosage               ;
    private Double price                ;
    private String     barcode              ;
    private Date       expirationDate       ;
    private Integer    manufacturerId       ;
    private String     recordStatus         ;
	private String photo;

	private String     createdAt            ;
    private Integer    createdBy            ;
	private String     updatedAt            ;
    private Integer    updatedBy            ;
    private Boolean    isDeleted            ;
	private String     deletedAt            ;
    private Integer    deletedBy            ;

	private String categoryName;
	private String manufacturerName;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	private SearchParam<Integer>  productIdParam        ;                     
	private SearchParam<String>   productNameParam      ;                     
	private SearchParam<String>   genericNameParam      ;                     
	private SearchParam<String>   brandNameParam        ;                     
	private SearchParam<String>   descriptionParam      ;                     
	private SearchParam<Integer>  categoryIdParam       ;                     
	private SearchParam<String>   dosageParam           ;                     
	private SearchParam<Double>priceParam            ;
	private SearchParam<String>   barcodeParam          ;                     
	private SearchParam<Date>     expirationDateParam   ;                     
	private SearchParam<Integer>  manufacturerIdParam   ;                     
	private SearchParam<String>   recordStatusParam     ;
	private SearchParam<String>   photoParam            ;
	private SearchParam<String>   createdAtParam        ;                     
	private SearchParam<Integer>  createdByParam        ;                     
	private SearchParam<String>   updatedAtParam        ;                     
	private SearchParam<Integer>  updatedByParam        ;                     
	private SearchParam<Boolean>  isDeletedParam        ;                     
	private SearchParam<String>   deletedAtParam        ;                     
	private SearchParam<Integer>  deletedByParam        ;
	private SearchParam<String>   categoryNameParam      ;
	private SearchParam<String>   manufacturerNameParam  ;
    /**
     * Default constructor
     */
    public ProductsDto()
    {
        super();
    }
    
	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
