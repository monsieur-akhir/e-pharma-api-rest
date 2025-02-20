

/*
 * Java controller for entity table product_categories 
 * Created on 2025-02-15 ( Time 03:02:44 )
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
Controller for table "product_categories"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/productCategories")
public class ProductCategoriesController {

	@Autowired
    private ControllerFactory<ProductCategoriesDto> controllerFactory;
	@Autowired
	private ProductCategoriesBusiness productCategoriesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductCategoriesDto> create(@RequestBody Request<ProductCategoriesDto> request) {
    	log.info("start method /productCategories/create");
        Response<ProductCategoriesDto> response = controllerFactory.create(productCategoriesBusiness, request, FunctionalityEnum.CREATE_PRODUCT_CATEGORIES);
		log.info("end method /productCategories/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductCategoriesDto> update(@RequestBody Request<ProductCategoriesDto> request) {
    	log.info("start method /productCategories/update");
        Response<ProductCategoriesDto> response = controllerFactory.update(productCategoriesBusiness, request, FunctionalityEnum.UPDATE_PRODUCT_CATEGORIES);
		log.info("end method /productCategories/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductCategoriesDto> delete(@RequestBody Request<ProductCategoriesDto> request) {
    	log.info("start method /productCategories/delete");
        Response<ProductCategoriesDto> response = controllerFactory.delete(productCategoriesBusiness, request, FunctionalityEnum.DELETE_PRODUCT_CATEGORIES);
		log.info("end method /productCategories/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProductCategoriesDto> getByCriteria(@RequestBody Request<ProductCategoriesDto> request) {
    	log.info("start method /productCategories/getByCriteria");
        Response<ProductCategoriesDto> response = controllerFactory.getByCriteria(productCategoriesBusiness, request, FunctionalityEnum.VIEW_PRODUCT_CATEGORIES);
		log.info("end method /productCategories/getByCriteria");
        return response;
    }
}
