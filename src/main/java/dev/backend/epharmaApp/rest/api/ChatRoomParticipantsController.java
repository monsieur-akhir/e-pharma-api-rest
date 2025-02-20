

/*
 * Java controller for entity table chat_room_participants 
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
Controller for table "chat_room_participants"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/chatRoomParticipants")
public class ChatRoomParticipantsController {

	@Autowired
    private ControllerFactory<ChatRoomParticipantsDto> controllerFactory;
	@Autowired
	private ChatRoomParticipantsBusiness chatRoomParticipantsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomParticipantsDto> create(@RequestBody Request<ChatRoomParticipantsDto> request) {
    	log.info("start method /chatRoomParticipants/create");
        Response<ChatRoomParticipantsDto> response = controllerFactory.create(chatRoomParticipantsBusiness, request, FunctionalityEnum.CREATE_CHAT_ROOM_PARTICIPANTS);
		log.info("end method /chatRoomParticipants/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomParticipantsDto> update(@RequestBody Request<ChatRoomParticipantsDto> request) {
    	log.info("start method /chatRoomParticipants/update");
        Response<ChatRoomParticipantsDto> response = controllerFactory.update(chatRoomParticipantsBusiness, request, FunctionalityEnum.UPDATE_CHAT_ROOM_PARTICIPANTS);
		log.info("end method /chatRoomParticipants/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomParticipantsDto> delete(@RequestBody Request<ChatRoomParticipantsDto> request) {
    	log.info("start method /chatRoomParticipants/delete");
        Response<ChatRoomParticipantsDto> response = controllerFactory.delete(chatRoomParticipantsBusiness, request, FunctionalityEnum.DELETE_CHAT_ROOM_PARTICIPANTS);
		log.info("end method /chatRoomParticipants/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomParticipantsDto> getByCriteria(@RequestBody Request<ChatRoomParticipantsDto> request) {
    	log.info("start method /chatRoomParticipants/getByCriteria");
        Response<ChatRoomParticipantsDto> response = controllerFactory.getByCriteria(chatRoomParticipantsBusiness, request, FunctionalityEnum.VIEW_CHAT_ROOM_PARTICIPANTS);
		log.info("end method /chatRoomParticipants/getByCriteria");
        return response;
    }
}
