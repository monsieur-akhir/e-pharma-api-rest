
/*
 * Java dto for entity table clients 
 * Created on 2025-02-15 ( Time 03:02:41 )
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
import dev.backend.epharmaApp.utils.dto.customize._ClientsDto;

/**
 * DTO for table "clients"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class ClientsDto extends _ClientsDto implements Cloneable{

    private Integer    clientId             ; // Primary Key

    private String     loginClient          ;
    private String     firstName            ;
    private String     lastName             ;
    private String     email                ;
    private String     phone                ;
    private String     address              ;
    private String     city                 ;
    private byte[]     location             ;
	private String     birthday             ;
    private String     photo                ;
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
	private SearchParam<Integer>  clientIdParam         ;                     
	private SearchParam<String>   loginClientParam      ;                     
	private SearchParam<String>   firstNameParam        ;                     
	private SearchParam<String>   lastNameParam         ;                     
	private SearchParam<String>   emailParam            ;                     
	private SearchParam<String>   phoneParam            ;                     
	private SearchParam<String>   addressParam          ;                     
	private SearchParam<String>   cityParam             ;                     
	private SearchParam<Byte[]>   locationParam         ;                     
	private SearchParam<String>   birthdayParam         ;                     
	private SearchParam<String>   photoParam            ;                     
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
    public ClientsDto()
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
