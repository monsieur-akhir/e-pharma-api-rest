
/*
 * Java dto for entity table orders 
 * Created on 2025-02-15 ( Time 03:02:42 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto;

import java.math.*;
import java.util.Date;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

import dev.backend.epharmaApp.utils.contract.*;
import dev.backend.epharmaApp.utils.dto.customize._OrdersDto;

/**
 * DTO for table "orders"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class OrdersDto extends _OrdersDto implements Cloneable{

    private Integer    orderId              ; // Primary Key

    private Integer    clientId             ;
	private String     orderDate            ;
    private String     orderStatus          ;
    private Double     totalAmount          ;
    private String     paymentMethod        ;
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
	private String clientsFirstName;
	private String clientsLastName;

	// Search param
	private SearchParam<Integer>  orderIdParam          ;                     
	private SearchParam<Integer>  clientIdParam         ;                     
	private SearchParam<String>   orderDateParam        ;                     
	private SearchParam<String>   orderStatusParam      ;                     
	private SearchParam<Double>   totalAmountParam      ;
	private SearchParam<String>   paymentMethodParam    ;                     
	private SearchParam<String>   recordStatusParam     ;                     
	private SearchParam<String>   createdAtParam        ;                     
	private SearchParam<Integer>  createdByParam        ;                     
	private SearchParam<String>   updatedAtParam        ;                     
	private SearchParam<Integer>  updatedByParam        ;                     
	private SearchParam<Boolean>  isDeletedParam        ;                     
	private SearchParam<String>   deletedAtParam        ;                     
	private SearchParam<Integer>  deletedByParam        ;                     
	private SearchParam<String>   clientsFirstNameParam ;                     
	private SearchParam<String>   clientsLastNameParam  ;                     
    /**
     * Default constructor
     */
    public OrdersDto()
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
