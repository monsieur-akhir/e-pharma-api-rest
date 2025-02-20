

/*
 * Java controller for entity table delivery_person_profiles 
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
Controller for table "delivery_person_profiles"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/deliveryPersonProfiles")
public class DeliveryPersonProfilesController {

	@Autowired
    private ControllerFactory<DeliveryPersonProfilesDto> controllerFactory;
	@Autowired
	private DeliveryPersonProfilesBusiness deliveryPersonProfilesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveryPersonProfilesDto> create(@RequestBody Request<DeliveryPersonProfilesDto> request) {
    	log.info("start method /deliveryPersonProfiles/create");
        Response<DeliveryPersonProfilesDto> response = controllerFactory.create(deliveryPersonProfilesBusiness, request, FunctionalityEnum.CREATE_DELIVERY_PERSON_PROFILES);
		log.info("end method /deliveryPersonProfiles/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveryPersonProfilesDto> update(@RequestBody Request<DeliveryPersonProfilesDto> request) {
    	log.info("start method /deliveryPersonProfiles/update");
        Response<DeliveryPersonProfilesDto> response = controllerFactory.update(deliveryPersonProfilesBusiness, request, FunctionalityEnum.UPDATE_DELIVERY_PERSON_PROFILES);
		log.info("end method /deliveryPersonProfiles/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveryPersonProfilesDto> delete(@RequestBody Request<DeliveryPersonProfilesDto> request) {
    	log.info("start method /deliveryPersonProfiles/delete");
        Response<DeliveryPersonProfilesDto> response = controllerFactory.delete(deliveryPersonProfilesBusiness, request, FunctionalityEnum.DELETE_DELIVERY_PERSON_PROFILES);
		log.info("end method /deliveryPersonProfiles/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<DeliveryPersonProfilesDto> getByCriteria(@RequestBody Request<DeliveryPersonProfilesDto> request) {
    	log.info("start method /deliveryPersonProfiles/getByCriteria");
        Response<DeliveryPersonProfilesDto> response = controllerFactory.getByCriteria(deliveryPersonProfilesBusiness, request, FunctionalityEnum.VIEW_DELIVERY_PERSON_PROFILES);
		log.info("end method /deliveryPersonProfiles/getByCriteria");
        return response;
    }
}
