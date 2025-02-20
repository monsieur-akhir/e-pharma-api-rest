

/*
 * Java controller for entity table pharmacies 
 * Created on 2025-02-15 ( Time 03:02:43 )
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
Controller for table "pharmacies"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/pharmacies")
public class PharmaciesController {

	@Autowired
    private ControllerFactory<PharmaciesDto> controllerFactory;
	@Autowired
	private PharmaciesBusiness pharmaciesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmaciesDto> create(@RequestBody Request<PharmaciesDto> request) {
    	log.info("start method /pharmacies/create");
        Response<PharmaciesDto> response = controllerFactory.create(pharmaciesBusiness, request, FunctionalityEnum.CREATE_PHARMACIES);
		log.info("end method /pharmacies/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmaciesDto> update(@RequestBody Request<PharmaciesDto> request) {
    	log.info("start method /pharmacies/update");
        Response<PharmaciesDto> response = controllerFactory.update(pharmaciesBusiness, request, FunctionalityEnum.UPDATE_PHARMACIES);
		log.info("end method /pharmacies/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmaciesDto> delete(@RequestBody Request<PharmaciesDto> request) {
    	log.info("start method /pharmacies/delete");
        Response<PharmaciesDto> response = controllerFactory.delete(pharmaciesBusiness, request, FunctionalityEnum.DELETE_PHARMACIES);
		log.info("end method /pharmacies/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmaciesDto> getByCriteria(@RequestBody Request<PharmaciesDto> request) {
    	log.info("start method /pharmacies/getByCriteria");
        Response<PharmaciesDto> response = controllerFactory.getByCriteria(pharmaciesBusiness, request, FunctionalityEnum.VIEW_PHARMACIES);
		log.info("end method /pharmacies/getByCriteria");
        return response;
    }
}
