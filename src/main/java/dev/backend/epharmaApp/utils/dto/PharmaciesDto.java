
/*
 * Java dto for entity table pharmacies 
 * Created on 2025-02-15 ( Time 03:02:43 )
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
import dev.backend.epharmaApp.utils.dto.customize._PharmaciesDto;

/**
 * DTO for table "pharmacies"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class PharmaciesDto extends _PharmaciesDto implements Cloneable{

    private Integer    pharmacyId           ; // Primary Key

    private String     pharmacyName         ;
    private String     address              ;
    private String     city                 ;
    private String     country              ;
    private String     phone                ;
    private byte[]     location             ;
    private String     logo                 ;
    private String     autorisation         ;
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
	private SearchParam<Integer>  pharmacyIdParam       ;                     
	private SearchParam<String>   pharmacyNameParam     ;                     
	private SearchParam<String>   addressParam          ;                     
	private SearchParam<String>   cityParam             ;                     
	private SearchParam<String>   countryParam          ;                     
	private SearchParam<String>   phoneParam            ;                     
	private SearchParam<Byte[]>   locationParam         ;                     
	private SearchParam<String>   logoParam             ;                     
	private SearchParam<String>   autorisationParam     ;                     
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
    public PharmaciesDto()
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
