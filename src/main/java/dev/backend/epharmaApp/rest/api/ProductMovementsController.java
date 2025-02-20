

/*
 * Java controller for entity table product_movements 
 * Created on 2025-02-15 ( Time 03:02:45 )
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
Controller for table "product_movements"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/productMovements")
public class ProductMovementsController {

	@Autowired
    private ControllerFactory<ProductMovementsDto> controllerFactory;
	@Autowired
	private ProductMovementsBusiness productMovementsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductMovementsDto> create(@RequestBody Request<ProductMovementsDto> request) {
    	log.info("start method /productMovements/create");
        Response<ProductMovementsDto> response = controllerFactory.create(productMovementsBusiness, request, FunctionalityEnum.CREATE_PRODUCT_MOVEMENTS);
		log.info("end method /productMovements/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductMovementsDto> update(@RequestBody Request<ProductMovementsDto> request) {
    	log.info("start method /productMovements/update");
        Response<ProductMovementsDto> response = controllerFactory.update(productMovementsBusiness, request, FunctionalityEnum.UPDATE_PRODUCT_MOVEMENTS);
		log.info("end method /productMovements/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductMovementsDto> delete(@RequestBody Request<ProductMovementsDto> request) {
    	log.info("start method /productMovements/delete");
        Response<ProductMovementsDto> response = controllerFactory.delete(productMovementsBusiness, request, FunctionalityEnum.DELETE_PRODUCT_MOVEMENTS);
		log.info("end method /productMovements/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductMovementsDto> getByCriteria(@RequestBody Request<ProductMovementsDto> request) {
    	log.info("start method /productMovements/getByCriteria");
        Response<ProductMovementsDto> response = controllerFactory.getByCriteria(productMovementsBusiness, request, FunctionalityEnum.VIEW_PRODUCT_MOVEMENTS);
		log.info("end method /productMovements/getByCriteria");
        return response;
    }
}
