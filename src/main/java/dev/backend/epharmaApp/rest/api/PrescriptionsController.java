

/*
 * Java controller for entity table prescriptions 
 * Created on 2025-02-15 ( Time 03:02:44 )
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
Controller for table "prescriptions"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/prescriptions")
public class PrescriptionsController {

	@Autowired
    private ControllerFactory<PrescriptionsDto> controllerFactory;
	@Autowired
	private PrescriptionsBusiness prescriptionsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionsDto> create(@RequestBody Request<PrescriptionsDto> request) {
    	log.info("start method /prescriptions/create");
        Response<PrescriptionsDto> response = controllerFactory.create(prescriptionsBusiness, request, FunctionalityEnum.CREATE_PRESCRIPTIONS);
		log.info("end method /prescriptions/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionsDto> update(@RequestBody Request<PrescriptionsDto> request) {
    	log.info("start method /prescriptions/update");
        Response<PrescriptionsDto> response = controllerFactory.update(prescriptionsBusiness, request, FunctionalityEnum.UPDATE_PRESCRIPTIONS);
		log.info("end method /prescriptions/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionsDto> delete(@RequestBody Request<PrescriptionsDto> request) {
    	log.info("start method /prescriptions/delete");
        Response<PrescriptionsDto> response = controllerFactory.delete(prescriptionsBusiness, request, FunctionalityEnum.DELETE_PRESCRIPTIONS);
		log.info("end method /prescriptions/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionsDto> getByCriteria(@RequestBody Request<PrescriptionsDto> request) {
    	log.info("start method /prescriptions/getByCriteria");
        Response<PrescriptionsDto> response = controllerFactory.getByCriteria(prescriptionsBusiness, request, FunctionalityEnum.VIEW_PRESCRIPTIONS);
		log.info("end method /prescriptions/getByCriteria");
        return response;
    }
}
