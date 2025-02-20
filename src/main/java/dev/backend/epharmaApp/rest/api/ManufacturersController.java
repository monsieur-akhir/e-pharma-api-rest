

/*
 * Java controller for entity table manufacturers 
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
Controller for table "manufacturers"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/manufacturers")
public class ManufacturersController {

	@Autowired
    private ControllerFactory<ManufacturersDto> controllerFactory;
	@Autowired
	private ManufacturersBusiness manufacturersBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ManufacturersDto> create(@RequestBody Request<ManufacturersDto> request) {
    	log.info("start method /manufacturers/create");
        Response<ManufacturersDto> response = controllerFactory.create(manufacturersBusiness, request, FunctionalityEnum.CREATE_MANUFACTURERS);
		log.info("end method /manufacturers/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ManufacturersDto> update(@RequestBody Request<ManufacturersDto> request) {
    	log.info("start method /manufacturers/update");
        Response<ManufacturersDto> response = controllerFactory.update(manufacturersBusiness, request, FunctionalityEnum.UPDATE_MANUFACTURERS);
		log.info("end method /manufacturers/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ManufacturersDto> delete(@RequestBody Request<ManufacturersDto> request) {
    	log.info("start method /manufacturers/delete");
        Response<ManufacturersDto> response = controllerFactory.delete(manufacturersBusiness, request, FunctionalityEnum.DELETE_MANUFACTURERS);
		log.info("end method /manufacturers/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ManufacturersDto> getByCriteria(@RequestBody Request<ManufacturersDto> request) {
    	log.info("start method /manufacturers/getByCriteria");
        Response<ManufacturersDto> response = controllerFactory.getByCriteria(manufacturersBusiness, request, FunctionalityEnum.VIEW_MANUFACTURERS);
		log.info("end method /manufacturers/getByCriteria");
        return response;
    }
}
