
/*
 * Java dto for entity table product_categories 
 * Created on 2025-02-15 ( Time 03:02:44 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto;

import java.util.Date;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

import dev.backend.epharmaApp.utils.contract.*;
import dev.backend.epharmaApp.utils.dto.customize._ProductCategoriesDto;

/**
 * DTO for table "product_categories"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class ProductCategoriesDto extends _ProductCategoriesDto implements Cloneable{

    private Integer    categoryId           ; // Primary Key

    private String     categoryName         ;
    private String     categoryDescription  ;
    private Integer    parentCategoryId     ;
    private String     recordStatus         ;
	private String     createdAt            ;
    private Integer    createdBy            ;
	private String     updatedAt            ;
    private Integer    updatedBy            ;
    private Boolean    isDeleted            ;
	private String     deletedAt            ;
    private Integer    deletedBy            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	private SearchParam<Integer>  categoryIdParam       ;                     
	private SearchParam<String>   categoryNameParam     ;                     
	private SearchParam<String>   categoryDescriptionParam;                     
	private SearchParam<Integer>  parentCategoryIdParam ;                     
	private SearchParam<String>   recordStatusParam     ;                     
	private SearchParam<String>   createdAtParam        ;                     
	private SearchParam<Integer>  createdByParam        ;                     
	private SearchParam<String>   updatedAtParam        ;                     
	private SearchParam<Integer>  updatedByParam        ;                     
	private SearchParam<Boolean>  isDeletedParam        ;                     
	private SearchParam<String>   deletedAtParam        ;                     
	private SearchParam<Integer>  deletedByParam        ;                     
    /**
     * Default constructor
     */
    public ProductCategoriesDto()
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
