

/*
 * Java controller for entity table stock_alerts 
 * Created on 2025-02-15 ( Time 03:02:47 )
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
Controller for table "stock_alerts"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/stockAlerts")
public class StockAlertsController {

	@Autowired
    private ControllerFactory<StockAlertsDto> controllerFactory;
	@Autowired
	private StockAlertsBusiness stockAlertsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAlertsDto> create(@RequestBody Request<StockAlertsDto> request) {
    	log.info("start method /stockAlerts/create");
        Response<StockAlertsDto> response = controllerFactory.create(stockAlertsBusiness, request, FunctionalityEnum.CREATE_STOCK_ALERTS);
		log.info("end method /stockAlerts/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAlertsDto> update(@RequestBody Request<StockAlertsDto> request) {
    	log.info("start method /stockAlerts/update");
        Response<StockAlertsDto> response = controllerFactory.update(stockAlertsBusiness, request, FunctionalityEnum.UPDATE_STOCK_ALERTS);
		log.info("end method /stockAlerts/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAlertsDto> delete(@RequestBody Request<StockAlertsDto> request) {
    	log.info("start method /stockAlerts/delete");
        Response<StockAlertsDto> response = controllerFactory.delete(stockAlertsBusiness, request, FunctionalityEnum.DELETE_STOCK_ALERTS);
		log.info("end method /stockAlerts/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAlertsDto> getByCriteria(@RequestBody Request<StockAlertsDto> request) {
    	log.info("start method /stockAlerts/getByCriteria");
        Response<StockAlertsDto> response = controllerFactory.getByCriteria(stockAlertsBusiness, request, FunctionalityEnum.VIEW_STOCK_ALERTS);
		log.info("end method /stockAlerts/getByCriteria");
        return response;
    }
}
