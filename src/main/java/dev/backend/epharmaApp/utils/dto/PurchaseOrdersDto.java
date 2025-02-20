
/*
 * Java dto for entity table purchase_orders 
 * Created on 2025-02-15 ( Time 03:02:46 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

import dev.backend.epharmaApp.utils.contract.*;
import dev.backend.epharmaApp.utils.dto.customize._PurchaseOrdersDto;

/**
 * DTO for table "purchase_orders"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class PurchaseOrdersDto extends _PurchaseOrdersDto implements Cloneable{

    private Integer    poId                 ; // Primary Key

    private Integer    pharmacyId           ;
    private Integer    manufacturerId       ;
	private String     orderDate            ;
    private String     status               ;
    private Double totalAmount          ;
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
	private SearchParam<Integer>  poIdParam             ;                     
	private SearchParam<Integer>  pharmacyIdParam       ;                     
	private SearchParam<Integer>  manufacturerIdParam   ;                     
	private SearchParam<String>   orderDateParam        ;                     
	private SearchParam<String>   statusParam           ;                     
	private SearchParam<Double>totalAmountParam      ;
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
    public PurchaseOrdersDto()
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
