

/*
 * Java controller for entity table chat_message_attachments 
 * Created on 2025-02-15 ( Time 03:02:40 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package dev.backend.epharmaApp.rest.api;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.backend.epharmaApp.utils.*;
import dev.backend.epharmaApp.utils.dto.*;
import dev.backend.epharmaApp.utils.contract.*;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.contract.Response;
import dev.backend.epharmaApp.utils.enums.FunctionalityEnum;
import dev.backend.epharmaApp.business.*;
import dev.backend.epharmaApp.rest.fact.ControllerFactory;

/**
Controller for table "chat_message_attachments"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/chatMessageAttachments")
public class ChatMessageAttachmentsController {

	@Autowired
    private ControllerFactory<ChatMessageAttachmentsDto> controllerFactory;
	@Autowired
	private ChatMessageAttachmentsBusiness chatMessageAttachmentsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessageAttachmentsDto> create(@RequestBody Request<ChatMessageAttachmentsDto> request) {
    	log.info("start method /chatMessageAttachments/create");
        Response<ChatMessageAttachmentsDto> response = controllerFactory.create(chatMessageAttachmentsBusiness, request, FunctionalityEnum.CREATE_CHAT_MESSAGE_ATTACHMENTS);
		log.info("end method /chatMessageAttachments/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessageAttachmentsDto> update(@RequestBody Request<ChatMessageAttachmentsDto> request) {
    	log.info("start method /chatMessageAttachments/update");
        Response<ChatMessageAttachmentsDto> response = controllerFactory.update(chatMessageAttachmentsBusiness, request, FunctionalityEnum.UPDATE_CHAT_MESSAGE_ATTACHMENTS);
		log.info("end method /chatMessageAttachments/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessageAttachmentsDto> delete(@RequestBody Request<ChatMessageAttachmentsDto> request) {
    	log.info("start method /chatMessageAttachments/delete");
        Response<ChatMessageAttachmentsDto> response = controllerFactory.delete(chatMessageAttachmentsBusiness, request, FunctionalityEnum.DELETE_CHAT_MESSAGE_ATTACHMENTS);
		log.info("end method /chatMessageAttachments/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessageAttachmentsDto> getByCriteria(@RequestBody Request<ChatMessageAttachmentsDto> request) {
    	log.info("start method /chatMessageAttachments/getByCriteria");
        Response<ChatMessageAttachmentsDto> response = controllerFactory.getByCriteria(chatMessageAttachmentsBusiness, request, FunctionalityEnum.VIEW_CHAT_MESSAGE_ATTACHMENTS);
		log.info("end method /chatMessageAttachments/getByCriteria");
        return response;
    }
}
