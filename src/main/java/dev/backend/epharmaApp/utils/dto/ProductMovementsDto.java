
/*
 * Java dto for entity table product_movements 
 * Created on 2025-02-15 ( Time 03:02:44 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto;

import java.util.Date;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

import dev.backend.epharmaApp.utils.contract.*;
import dev.backend.epharmaApp.utils.dto.customize._ProductMovementsDto;

/**
 * DTO for table "product_movements"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class ProductMovementsDto extends _ProductMovementsDto implements Cloneable{

    private Integer    movementId           ; // Primary Key

    private Integer    productId            ;
    private String     fromEntity           ;
    private String     toEntity             ;
	private String     movementDate         ;
    private Integer    quantity             ;
    private String     remarks              ;
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
	private SearchParam<Integer>  movementIdParam       ;                     
	private SearchParam<Integer>  productIdParam        ;                     
	private SearchParam<String>   fromEntityParam       ;                     
	private SearchParam<String>   toEntityParam         ;                     
	private SearchParam<String>   movementDateParam     ;                     
	private SearchParam<Integer>  quantityParam         ;                     
	private SearchParam<String>   remarksParam          ;                     
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
    public ProductMovementsDto()
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
