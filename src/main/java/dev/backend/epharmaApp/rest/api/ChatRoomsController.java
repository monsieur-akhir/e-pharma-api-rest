

/*
 * Java controller for entity table chat_rooms 
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
Controller for table "chat_rooms"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/chatRooms")
public class ChatRoomsController {

	@Autowired
    private ControllerFactory<ChatRoomsDto> controllerFactory;
	@Autowired
	private ChatRoomsBusiness chatRoomsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomsDto> create(@RequestBody Request<ChatRoomsDto> request) {
    	log.info("start method /chatRooms/create");
        Response<ChatRoomsDto> response = controllerFactory.create(chatRoomsBusiness, request, FunctionalityEnum.CREATE_CHAT_ROOMS);
		log.info("end method /chatRooms/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomsDto> update(@RequestBody Request<ChatRoomsDto> request) {
    	log.info("start method /chatRooms/update");
        Response<ChatRoomsDto> response = controllerFactory.update(chatRoomsBusiness, request, FunctionalityEnum.UPDATE_CHAT_ROOMS);
		log.info("end method /chatRooms/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomsDto> delete(@RequestBody Request<ChatRoomsDto> request) {
    	log.info("start method /chatRooms/delete");
        Response<ChatRoomsDto> response = controllerFactory.delete(chatRoomsBusiness, request, FunctionalityEnum.DELETE_CHAT_ROOMS);
		log.info("end method /chatRooms/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ChatRoomsDto> getByCriteria(@RequestBody Request<ChatRoomsDto> request) {
    	log.info("start method /chatRooms/getByCriteria");
        Response<ChatRoomsDto> response = controllerFactory.getByCriteria(chatRoomsBusiness, request, FunctionalityEnum.VIEW_CHAT_ROOMS);
		log.info("end method /chatRooms/getByCriteria");
        return response;
    }
}
