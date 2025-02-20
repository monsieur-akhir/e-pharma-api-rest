

/*
 * Java controller for entity table clients 
 * Created on 2025-02-15 ( Time 03:02:41 )
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
Controller for table "clients"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/clients")
public class ClientsController {

	@Autowired
    private ControllerFactory<ClientsDto> controllerFactory;
	@Autowired
	private ClientsBusiness clientsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientsDto> create(@RequestBody Request<ClientsDto> request) {
    	log.info("start method /clients/create");
        Response<ClientsDto> response = controllerFactory.create(clientsBusiness, request, FunctionalityEnum.CREATE_CLIENTS);
		log.info("end method /clients/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientsDto> update(@RequestBody Request<ClientsDto> request) {
    	log.info("start method /clients/update");
        Response<ClientsDto> response = controllerFactory.update(clientsBusiness, request, FunctionalityEnum.UPDATE_CLIENTS);
		log.info("end method /clients/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientsDto> delete(@RequestBody Request<ClientsDto> request) {
    	log.info("start method /clients/delete");
        Response<ClientsDto> response = controllerFactory.delete(clientsBusiness, request, FunctionalityEnum.DELETE_CLIENTS);
		log.info("end method /clients/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientsDto> getByCriteria(@RequestBody Request<ClientsDto> request) {
    	log.info("start method /clients/getByCriteria");
        Response<ClientsDto> response = controllerFactory.getByCriteria(clientsBusiness, request, FunctionalityEnum.VIEW_CLIENTS);
		log.info("end method /clients/getByCriteria");
        return response;
    }
}
