

/*
 * Java controller for entity table purchase_order_items 
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
Controller for table "purchase_order_items"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/purchaseOrderItems")
public class PurchaseOrderItemsController {

	@Autowired
    private ControllerFactory<PurchaseOrderItemsDto> controllerFactory;
	@Autowired
	private PurchaseOrderItemsBusiness purchaseOrderItemsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrderItemsDto> create(@RequestBody Request<PurchaseOrderItemsDto> request) {
    	log.info("start method /purchaseOrderItems/create");
        Response<PurchaseOrderItemsDto> response = controllerFactory.create(purchaseOrderItemsBusiness, request, FunctionalityEnum.CREATE_PURCHASE_ORDER_ITEMS);
		log.info("end method /purchaseOrderItems/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrderItemsDto> update(@RequestBody Request<PurchaseOrderItemsDto> request) {
    	log.info("start method /purchaseOrderItems/update");
        Response<PurchaseOrderItemsDto> response = controllerFactory.update(purchaseOrderItemsBusiness, request, FunctionalityEnum.UPDATE_PURCHASE_ORDER_ITEMS);
		log.info("end method /purchaseOrderItems/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrderItemsDto> delete(@RequestBody Request<PurchaseOrderItemsDto> request) {
    	log.info("start method /purchaseOrderItems/delete");
        Response<PurchaseOrderItemsDto> response = controllerFactory.delete(purchaseOrderItemsBusiness, request, FunctionalityEnum.DELETE_PURCHASE_ORDER_ITEMS);
		log.info("end method /purchaseOrderItems/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PurchaseOrderItemsDto> getByCriteria(@RequestBody Request<PurchaseOrderItemsDto> request) {
    	log.info("start method /purchaseOrderItems/getByCriteria");
        Response<PurchaseOrderItemsDto> response = controllerFactory.getByCriteria(purchaseOrderItemsBusiness, request, FunctionalityEnum.VIEW_PURCHASE_ORDER_ITEMS);
		log.info("end method /purchaseOrderItems/getByCriteria");
        return response;
    }
}
