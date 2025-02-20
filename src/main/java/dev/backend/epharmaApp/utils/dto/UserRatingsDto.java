
/*
 * Java dto for entity table user_ratings 
 * Created on 2025-02-15 ( Time 03:02:47 )
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
import dev.backend.epharmaApp.utils.dto.customize._UserRatingsDto;

/**
 * DTO for table "user_ratings"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class UserRatingsDto extends _UserRatingsDto implements Cloneable{

    private Integer    ratingId             ; // Primary Key

    private Integer    ratedUserId          ;
    private Integer    raterId              ;
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
	private String usersLogin;
	private String usersFirstName;
	private String usersLastName;
	private String users2Login;
	private String users2FirstName;
	private String users2LastName;

	// Search param
	private SearchParam<Integer>  ratingIdParam         ;                     
	private SearchParam<Integer>  ratedUserIdParam      ;                     
	private SearchParam<Integer>  raterIdParam          ;                     
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
	private SearchParam<String>   usersLoginParam       ;                     
	private SearchParam<String>   usersFirstNameParam   ;                     
	private SearchParam<String>   usersLastNameParam    ;                     
	private SearchParam<String>   users2LoginParam       ;
	private SearchParam<String>   users2FirstNameParam   ;
	private SearchParam<String>   users2LastNameParam    ;
    /**
     * Default constructor
     */
    public UserRatingsDto()
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
