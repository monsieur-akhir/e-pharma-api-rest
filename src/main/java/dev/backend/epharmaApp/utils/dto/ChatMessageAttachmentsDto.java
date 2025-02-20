
/*
 * Java dto for entity table chat_message_attachments 
 * Created on 2025-02-15 ( Time 03:02:39 )
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
import dev.backend.epharmaApp.utils.dto.customize._ChatMessageAttachmentsDto;

/**
 * DTO for table "chat_message_attachments"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class ChatMessageAttachmentsDto extends _ChatMessageAttachmentsDto implements Cloneable{

    private Integer    attachmentId         ; // Primary Key

    private Integer    messageId            ;
    private String     fileType             ;
    private String     fileName             ;
    private String     fileData             ;
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
	private SearchParam<Integer>  attachmentIdParam     ;                     
	private SearchParam<Integer>  messageIdParam        ;                     
	private SearchParam<String>   fileTypeParam         ;                     
	private SearchParam<String>   fileNameParam         ;                     
	private SearchParam<String>   fileDataParam         ;                     
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
    public ChatMessageAttachmentsDto()
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
