
/*
 * Java dto for entity table users 
 * Created on 2025-02-15 ( Time 03:02:48 )
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
import dev.backend.epharmaApp.utils.dto.customize._UsersDto;

/**
 * DTO for table "users"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class UsersDto extends _UsersDto implements Cloneable{

    private Integer    userId               ; // Primary Key

    private String     login                ;
    private String     email                ;
    private String     firstName            ;
    private String     lastName             ;
    private String     passwordHash         ;
    private String     phone                ;
    private String     address              ;
    private String     city                 ;
    private String     country              ;
    private Integer    pharmacyId           ;
    private String     recordStatus         ;
	private String     createdAt            ;
    private Integer    createdBy            ;
	private String     updatedAt            ;
    private Integer    updatedBy            ;
    private Boolean    isDeleted            ;
	private String     deletedAt            ;
    private Integer    deletedBy            ;
	private String     pharmacyName         ;
	private String     pharmacyAddress      ;
	private Integer     roleId               ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	private SearchParam<Integer>  userIdParam           ;                     
	private SearchParam<String>   loginParam            ;                     
	private SearchParam<String>   emailParam            ;                     
	private SearchParam<String>   firstNameParam        ;                     
	private SearchParam<String>   lastNameParam         ;                     
	private SearchParam<String>   passwordHashParam     ;                     
	private SearchParam<String>   phoneParam            ;                     
	private SearchParam<String>   addressParam          ;                     
	private SearchParam<String>   cityParam             ;                     
	private SearchParam<String>   countryParam          ;                     
	private SearchParam<Integer>  pharmacyIdParam       ;                     
	private SearchParam<String>   recordStatusParam     ;                     
	private SearchParam<String>   createdAtParam        ;                     
	private SearchParam<Integer>  createdByParam        ;                     
	private SearchParam<String>   updatedAtParam        ;                     
	private SearchParam<Integer>  updatedByParam        ;                     
	private SearchParam<Boolean>  isDeletedParam        ;                     
	private SearchParam<String>   deletedAtParam        ;                     
	private SearchParam<Integer>  deletedByParam        ;
	private SearchParam<String>   pharmacyNameParam      ;
	private SearchParam<String>   pharmacyAddressParam   ;
	private SearchParam<Integer>  roleIdParam            ;
    /**
     * Default constructor
     */
    public UsersDto()
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
