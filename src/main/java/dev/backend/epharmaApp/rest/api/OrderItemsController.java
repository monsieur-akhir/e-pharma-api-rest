

/*
 * Java controller for entity table order_items 
 * Created on 2025-02-15 ( Time 03:02:42 )
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
Controller for table "order_items"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/orderItems")
public class OrderItemsController {

	@Autowired
    private ControllerFactory<OrderItemsDto> controllerFactory;
	@Autowired
	private OrderItemsBusiness orderItemsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrderItemsDto> create(@RequestBody Request<OrderItemsDto> request) {
    	log.info("start method /orderItems/create");
        Response<OrderItemsDto> response = controllerFactory.create(orderItemsBusiness, request, FunctionalityEnum.CREATE_ORDER_ITEMS);
		log.info("end method /orderItems/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrderItemsDto> update(@RequestBody Request<OrderItemsDto> request) {
    	log.info("start method /orderItems/update");
        Response<OrderItemsDto> response = controllerFactory.update(orderItemsBusiness, request, FunctionalityEnum.UPDATE_ORDER_ITEMS);
		log.info("end method /orderItems/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrderItemsDto> delete(@RequestBody Request<OrderItemsDto> request) {
    	log.info("start method /orderItems/delete");
        Response<OrderItemsDto> response = controllerFactory.delete(orderItemsBusiness, request, FunctionalityEnum.DELETE_ORDER_ITEMS);
		log.info("end method /orderItems/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<OrderItemsDto> getByCriteria(@RequestBody Request<OrderItemsDto> request) {
    	log.info("start method /orderItems/getByCriteria");
        Response<OrderItemsDto> response = controllerFactory.getByCriteria(orderItemsBusiness, request, FunctionalityEnum.VIEW_ORDER_ITEMS);
		log.info("end method /orderItems/getByCriteria");
        return response;
    }
}
