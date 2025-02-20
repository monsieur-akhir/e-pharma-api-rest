

/*
 * Java controller for entity table products 
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
Controller for table "products"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/products")
public class ProductsController {

	@Autowired
    private ControllerFactory<ProductsDto> controllerFactory;
	@Autowired
	private ProductsBusiness productsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductsDto> create(@RequestBody Request<ProductsDto> request) {
    	log.info("start method /products/create");
        Response<ProductsDto> response = controllerFactory.create(productsBusiness, request, FunctionalityEnum.CREATE_PRODUCTS);
		log.info("end method /products/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductsDto> update(@RequestBody Request<ProductsDto> request) {
    	log.info("start method /products/update");
        Response<ProductsDto> response = controllerFactory.update(productsBusiness, request, FunctionalityEnum.UPDATE_PRODUCTS);
		log.info("end method /products/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductsDto> delete(@RequestBody Request<ProductsDto> request) {
    	log.info("start method /products/delete");
        Response<ProductsDto> response = controllerFactory.delete(productsBusiness, request, FunctionalityEnum.DELETE_PRODUCTS);
		log.info("end method /products/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductsDto> getByCriteria(@RequestBody Request<ProductsDto> request) {
    	log.info("start method /products/getByCriteria");
        Response<ProductsDto> response = controllerFactory.getByCriteria(productsBusiness, request, FunctionalityEnum.VIEW_PRODUCTS);
		log.info("end method /products/getByCriteria");
        return response;
    }
}
