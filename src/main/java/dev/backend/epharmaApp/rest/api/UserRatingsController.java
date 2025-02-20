

/*
 * Java controller for entity table user_ratings 
 * Created on 2025-02-15 ( Time 03:02:48 )
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
Controller for table "user_ratings"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/userRatings")
public class UserRatingsController {

	@Autowired
    private ControllerFactory<UserRatingsDto> controllerFactory;
	@Autowired
	private UserRatingsBusiness userRatingsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRatingsDto> create(@RequestBody Request<UserRatingsDto> request) {
    	log.info("start method /userRatings/create");
        Response<UserRatingsDto> response = controllerFactory.create(userRatingsBusiness, request, FunctionalityEnum.CREATE_USER_RATINGS);
		log.info("end method /userRatings/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRatingsDto> update(@RequestBody Request<UserRatingsDto> request) {
    	log.info("start method /userRatings/update");
        Response<UserRatingsDto> response = controllerFactory.update(userRatingsBusiness, request, FunctionalityEnum.UPDATE_USER_RATINGS);
		log.info("end method /userRatings/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRatingsDto> delete(@RequestBody Request<UserRatingsDto> request) {
    	log.info("start method /userRatings/delete");
        Response<UserRatingsDto> response = controllerFactory.delete(userRatingsBusiness, request, FunctionalityEnum.DELETE_USER_RATINGS);
		log.info("end method /userRatings/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UserRatingsDto> getByCriteria(@RequestBody Request<UserRatingsDto> request) {
    	log.info("start method /userRatings/getByCriteria");
        Response<UserRatingsDto> response = controllerFactory.getByCriteria(userRatingsBusiness, request, FunctionalityEnum.VIEW_USER_RATINGS);
		log.info("end method /userRatings/getByCriteria");
        return response;
    }
}
