
/*
 * Java dto for entity table pharmacy_ratings 
 * Created on 2025-02-15 ( Time 03:02:43 )
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
import dev.backend.epharmaApp.utils.dto.customize._PharmacyRatingsDto;

/**
 * DTO for table "pharmacy_ratings"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class PharmacyRatingsDto extends _PharmacyRatingsDto implements Cloneable{

    private Integer    ratingId             ; // Primary Key

    private Integer    pharmacyId           ;
    private Integer    clientId             ;
    private Byte       ratingValue          ;
    private String     comment              ;
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
	private SearchParam<Integer>  ratingIdParam         ;                     
	private SearchParam<Integer>  pharmacyIdParam       ;                     
	private SearchParam<Integer>  clientIdParam         ;                     
	private SearchParam<Byte>     ratingValueParam      ;                     
	private SearchParam<String>   commentParam          ;                     
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
    public PharmacyRatingsDto()
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
