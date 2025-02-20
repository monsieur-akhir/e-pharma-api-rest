

/*
 * Java controller for entity table deliveries 
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
Controller for table "deliveries"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/deliveries")
public class DeliveriesController {

	@Autowired
    private ControllerFactory<DeliveriesDto> controllerFactory;
	@Autowired
	private DeliveriesBusiness deliveriesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveriesDto> create(@RequestBody Request<DeliveriesDto> request) {
    	log.info("start method /deliveries/create");
        Response<DeliveriesDto> response = controllerFactory.create(deliveriesBusiness, request, FunctionalityEnum.CREATE_DELIVERIES);
		log.info("end method /deliveries/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveriesDto> update(@RequestBody Request<DeliveriesDto> request) {
    	log.info("start method /deliveries/update");
        Response<DeliveriesDto> response = controllerFactory.update(deliveriesBusiness, request, FunctionalityEnum.UPDATE_DELIVERIES);
		log.info("end method /deliveries/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveriesDto> delete(@RequestBody Request<DeliveriesDto> request) {
    	log.info("start method /deliveries/delete");
        Response<DeliveriesDto> response = controllerFactory.delete(deliveriesBusiness, request, FunctionalityEnum.DELETE_DELIVERIES);
		log.info("end method /deliveries/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveriesDto> getByCriteria(@RequestBody Request<DeliveriesDto> request) {
    	log.info("start method /deliveries/getByCriteria");
        Response<DeliveriesDto> response = controllerFactory.getByCriteria(deliveriesBusiness, request, FunctionalityEnum.VIEW_DELIVERIES);
		log.info("end method /deliveries/getByCriteria");
        return response;
    }
}
