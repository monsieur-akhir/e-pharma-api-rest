

/*
 * Java controller for entity table purchase_orders 
 * Created on 2025-02-15 ( Time 03:02:46 )
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
Controller for table "purchase_orders"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/purchaseOrders")
public class PurchaseOrdersController {

	@Autowired
    private ControllerFactory<PurchaseOrdersDto> controllerFactory;
	@Autowired
	private PurchaseOrdersBusiness purchaseOrdersBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrdersDto> create(@RequestBody Request<PurchaseOrdersDto> request) {
    	log.info("start method /purchaseOrders/create");
        Response<PurchaseOrdersDto> response = controllerFactory.create(purchaseOrdersBusiness, request, FunctionalityEnum.CREATE_PURCHASE_ORDERS);
		log.info("end method /purchaseOrders/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrdersDto> update(@RequestBody Request<PurchaseOrdersDto> request) {
    	log.info("start method /purchaseOrders/update");
        Response<PurchaseOrdersDto> response = controllerFactory.update(purchaseOrdersBusiness, request, FunctionalityEnum.UPDATE_PURCHASE_ORDERS);
		log.info("end method /purchaseOrders/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrdersDto> delete(@RequestBody Request<PurchaseOrdersDto> request) {
    	log.info("start method /purchaseOrders/delete");
        Response<PurchaseOrdersDto> response = controllerFactory.delete(purchaseOrdersBusiness, request, FunctionalityEnum.DELETE_PURCHASE_ORDERS);
		log.info("end method /purchaseOrders/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrdersDto> getByCriteria(@RequestBody Request<PurchaseOrdersDto> request) {
    	log.info("start method /purchaseOrders/getByCriteria");
        Response<PurchaseOrdersDto> response = controllerFactory.getByCriteria(purchaseOrdersBusiness, request, FunctionalityEnum.VIEW_PURCHASE_ORDERS);
		log.info("end method /purchaseOrders/getByCriteria");
        return response;
    }
}
