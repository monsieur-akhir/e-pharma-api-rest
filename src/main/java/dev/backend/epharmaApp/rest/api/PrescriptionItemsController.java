

/*
 * Java controller for entity table prescription_items 
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
Controller for table "prescription_items"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/prescriptionItems")
public class PrescriptionItemsController {

	@Autowired
    private ControllerFactory<PrescriptionItemsDto> controllerFactory;
	@Autowired
	private PrescriptionItemsBusiness prescriptionItemsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionItemsDto> create(@RequestBody Request<PrescriptionItemsDto> request) {
    	log.info("start method /prescriptionItems/create");
        Response<PrescriptionItemsDto> response = controllerFactory.create(prescriptionItemsBusiness, request, FunctionalityEnum.CREATE_PRESCRIPTION_ITEMS);
		log.info("end method /prescriptionItems/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionItemsDto> update(@RequestBody Request<PrescriptionItemsDto> request) {
    	log.info("start method /prescriptionItems/update");
        Response<PrescriptionItemsDto> response = controllerFactory.update(prescriptionItemsBusiness, request, FunctionalityEnum.UPDATE_PRESCRIPTION_ITEMS);
		log.info("end method /prescriptionItems/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionItemsDto> delete(@RequestBody Request<PrescriptionItemsDto> request) {
    	log.info("start method /prescriptionItems/delete");
        Response<PrescriptionItemsDto> response = controllerFactory.delete(prescriptionItemsBusiness, request, FunctionalityEnum.DELETE_PRESCRIPTION_ITEMS);
		log.info("end method /prescriptionItems/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrescriptionItemsDto> getByCriteria(@RequestBody Request<PrescriptionItemsDto> request) {
    	log.info("start method /prescriptionItems/getByCriteria");
        Response<PrescriptionItemsDto> response = controllerFactory.getByCriteria(prescriptionItemsBusiness, request, FunctionalityEnum.VIEW_PRESCRIPTION_ITEMS);
		log.info("end method /prescriptionItems/getByCriteria");
        return response;
    }
}
