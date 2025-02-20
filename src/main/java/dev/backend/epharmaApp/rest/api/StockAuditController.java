

/*
 * Java controller for entity table stock_audit 
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
Controller for table "stock_audit"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/stockAudit")
public class StockAuditController {

	@Autowired
    private ControllerFactory<StockAuditDto> controllerFactory;
	@Autowired
	private StockAuditBusiness stockAuditBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAuditDto> create(@RequestBody Request<StockAuditDto> request) {
    	log.info("start method /stockAudit/create");
        Response<StockAuditDto> response = controllerFactory.create(stockAuditBusiness, request, FunctionalityEnum.CREATE_STOCK_AUDIT);
		log.info("end method /stockAudit/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAuditDto> update(@RequestBody Request<StockAuditDto> request) {
    	log.info("start method /stockAudit/update");
        Response<StockAuditDto> response = controllerFactory.update(stockAuditBusiness, request, FunctionalityEnum.UPDATE_STOCK_AUDIT);
		log.info("end method /stockAudit/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAuditDto> delete(@RequestBody Request<StockAuditDto> request) {
    	log.info("start method /stockAudit/delete");
        Response<StockAuditDto> response = controllerFactory.delete(stockAuditBusiness, request, FunctionalityEnum.DELETE_STOCK_AUDIT);
		log.info("end method /stockAudit/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<StockAuditDto> getByCriteria(@RequestBody Request<StockAuditDto> request) {
    	log.info("start method /stockAudit/getByCriteria");
        Response<StockAuditDto> response = controllerFactory.getByCriteria(stockAuditBusiness, request, FunctionalityEnum.VIEW_STOCK_AUDIT);
		log.info("end method /stockAudit/getByCriteria");
        return response;
    }
}
