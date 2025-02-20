
/*
 * Java dto for entity table deliveries 
 * Created on 2025-02-15 ( Time 03:02:41 )
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
import dev.backend.epharmaApp.utils.dto.customize._DeliveriesDto;

/**
 * DTO for table "deliveries"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class DeliveriesDto extends _DeliveriesDto implements Cloneable{

    private Integer    deliveryId           ; // Primary Key

    private Integer    orderId              ;
    private Integer    pharmacyId           ;
    private Integer    assignedTo           ;
    private String     deliveryStatus       ;
	private String     expectedDeliveryDate ;
	private String     actualDeliveryDate   ;
    private String     trackingNumber       ;
    private String     deliveryMethod       ;
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
	private String usersLogin;
	private String usersFirstName;
	private String usersLastName;

	// Search param
	private SearchParam<Integer>  deliveryIdParam       ;                     
	private SearchParam<Integer>  orderIdParam          ;                     
	private SearchParam<Integer>  pharmacyIdParam       ;                     
	private SearchParam<Integer>  assignedToParam       ;                     
	private SearchParam<String>   deliveryStatusParam   ;                     
	private SearchParam<String>   expectedDeliveryDateParam;                     
	private SearchParam<String>   actualDeliveryDateParam;                     
	private SearchParam<String>   trackingNumberParam   ;                     
	private SearchParam<String>   deliveryMethodParam   ;                     
	private SearchParam<String>   recordStatusParam     ;                     
	private SearchParam<String>   createdAtParam        ;                     
	private SearchParam<Integer>  createdByParam        ;                     
	private SearchParam<String>   updatedAtParam        ;                     
	private SearchParam<Integer>  updatedByParam        ;                     
	private SearchParam<Boolean>  isDeletedParam        ;                     
	private SearchParam<String>   deletedAtParam        ;                     
	private SearchParam<Integer>  deletedByParam        ;                     
	private SearchParam<String>   usersLoginParam       ;                     
	private SearchParam<String>   usersFirstNameParam   ;                     
	private SearchParam<String>   usersLastNameParam    ;                     
    /**
     * Default constructor
     */
    public DeliveriesDto()
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
