
/*
 * Java dto for entity table chat_messages 
 * Created on 2025-02-15 ( Time 03:02:40 )
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
import dev.backend.epharmaApp.utils.dto.customize._ChatMessagesDto;

/**
 * DTO for table "chat_messages"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class ChatMessagesDto extends _ChatMessagesDto implements Cloneable{

    private Integer    messageId            ; // Primary Key

    private Integer    roomId               ;
    private Integer    senderId             ;
    private String     message              ;
	private String     sentAt               ;
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
	private SearchParam<Integer>  messageIdParam        ;                     
	private SearchParam<Integer>  roomIdParam           ;                     
	private SearchParam<Integer>  senderIdParam         ;                     
	private SearchParam<String>   messageParam          ;                     
	private SearchParam<String>   sentAtParam           ;                     
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
    public ChatMessagesDto()
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
