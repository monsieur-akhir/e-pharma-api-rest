

/*
 * Java controller for entity table stock 
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
Controller for table "stock"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/stock")
public class StockController {

	@Autowired
    private ControllerFactory<StockDto> controllerFactory;
	@Autowired
	private StockBusiness stockBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockDto> create(@RequestBody Request<StockDto> request) {
    	log.info("start method /stock/create");
        Response<StockDto> response = controllerFactory.create(stockBusiness, request, FunctionalityEnum.CREATE_STOCK);
		log.info("end method /stock/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockDto> update(@RequestBody Request<StockDto> request) {
    	log.info("start method /stock/update");
        Response<StockDto> response = controllerFactory.update(stockBusiness, request, FunctionalityEnum.UPDATE_STOCK);
		log.info("end method /stock/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockDto> delete(@RequestBody Request<StockDto> request) {
    	log.info("start method /stock/delete");
        Response<StockDto> response = controllerFactory.delete(stockBusiness, request, FunctionalityEnum.DELETE_STOCK);
		log.info("end method /stock/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockDto> getByCriteria(@RequestBody Request<StockDto> request) {
    	log.info("start method /stock/getByCriteria");
        Response<StockDto> response = controllerFactory.getByCriteria(stockBusiness, request, FunctionalityEnum.VIEW_STOCK);
		log.info("end method /stock/getByCriteria");
        return response;
    }
}
