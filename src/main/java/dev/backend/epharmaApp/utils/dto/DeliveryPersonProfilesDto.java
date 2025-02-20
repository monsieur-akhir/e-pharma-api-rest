
/*
 * Java dto for entity table delivery_person_profiles 
 * Created on 2025-02-15 ( Time 03:02:41 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.backend.epharmaApp.utils.contract.SearchParam;
import dev.backend.epharmaApp.utils.dto.customize._DeliveryPersonProfilesDto;
import lombok.Data;
import lombok.ToString;

/**
 * DTO for table "delivery_person_profiles"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class DeliveryPersonProfilesDto extends _DeliveryPersonProfilesDto implements Cloneable{

    private Integer    userId               ; // Primary Key
	private Integer    deliveryPersonId     ;
    private String     status               ;
	private String     registeredDate       ;
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
	private SearchParam<Integer>  userIdParam           ;
	private SearchParam<Integer>  deliveryPersonIdParam ;
	private SearchParam<String>   statusParam           ;                     
	private SearchParam<String>   registeredDateParam   ;                     
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
    public DeliveryPersonProfilesDto()
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
