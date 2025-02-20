

/*
 * Java controller for entity table pharmacy_ratings 
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
Controller for table "pharmacy_ratings"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/pharmacyRatings")
public class PharmacyRatingsController {

	@Autowired
    private ControllerFactory<PharmacyRatingsDto> controllerFactory;
	@Autowired
	private PharmacyRatingsBusiness pharmacyRatingsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacyRatingsDto> create(@RequestBody Request<PharmacyRatingsDto> request) {
    	log.info("start method /pharmacyRatings/create");
        Response<PharmacyRatingsDto> response = controllerFactory.create(pharmacyRatingsBusiness, request, FunctionalityEnum.CREATE_PHARMACY_RATINGS);
		log.info("end method /pharmacyRatings/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacyRatingsDto> update(@RequestBody Request<PharmacyRatingsDto> request) {
    	log.info("start method /pharmacyRatings/update");
        Response<PharmacyRatingsDto> response = controllerFactory.update(pharmacyRatingsBusiness, request, FunctionalityEnum.UPDATE_PHARMACY_RATINGS);
		log.info("end method /pharmacyRatings/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacyRatingsDto> delete(@RequestBody Request<PharmacyRatingsDto> request) {
    	log.info("start method /pharmacyRatings/delete");
        Response<PharmacyRatingsDto> response = controllerFactory.delete(pharmacyRatingsBusiness, request, FunctionalityEnum.DELETE_PHARMACY_RATINGS);
		log.info("end method /pharmacyRatings/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PharmacyRatingsDto> getByCriteria(@RequestBody Request<PharmacyRatingsDto> request) {
    	log.info("start method /pharmacyRatings/getByCriteria");
        Response<PharmacyRatingsDto> response = controllerFactory.getByCriteria(pharmacyRatingsBusiness, request, FunctionalityEnum.VIEW_PHARMACY_RATINGS);
		log.info("end method /pharmacyRatings/getByCriteria");
        return response;
    }
}
