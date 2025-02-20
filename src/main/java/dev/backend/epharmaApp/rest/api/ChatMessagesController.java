

/*
 * Java controller for entity table chat_messages 
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
Controller for table "chat_messages"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/chatMessages")
public class ChatMessagesController {

	@Autowired
    private ControllerFactory<ChatMessagesDto> controllerFactory;
	@Autowired
	private ChatMessagesBusiness chatMessagesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessagesDto> create(@RequestBody Request<ChatMessagesDto> request) {
    	log.info("start method /chatMessages/create");
        Response<ChatMessagesDto> response = controllerFactory.create(chatMessagesBusiness, request, FunctionalityEnum.CREATE_CHAT_MESSAGES);
		log.info("end method /chatMessages/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessagesDto> update(@RequestBody Request<ChatMessagesDto> request) {
    	log.info("start method /chatMessages/update");
        Response<ChatMessagesDto> response = controllerFactory.update(chatMessagesBusiness, request, FunctionalityEnum.UPDATE_CHAT_MESSAGES);
		log.info("end method /chatMessages/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessagesDto> delete(@RequestBody Request<ChatMessagesDto> request) {
    	log.info("start method /chatMessages/delete");
        Response<ChatMessagesDto> response = controllerFactory.delete(chatMessagesBusiness, request, FunctionalityEnum.DELETE_CHAT_MESSAGES);
		log.info("end method /chatMessages/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatMessagesDto> getByCriteria(@RequestBody Request<ChatMessagesDto> request) {
    	log.info("start method /chatMessages/getByCriteria");
        Response<ChatMessagesDto> response = controllerFactory.getByCriteria(chatMessagesBusiness, request, FunctionalityEnum.VIEW_CHAT_MESSAGES);
		log.info("end method /chatMessages/getByCriteria");
        return response;
    }
}
