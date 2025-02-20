

/*
 * Java controller for entity table role_permissions 
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
Controller for table "role_permissions"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/rolePermissions")
public class RolePermissionsController {

	@Autowired
    private ControllerFactory<RolePermissionsDto> controllerFactory;
	@Autowired
	private RolePermissionsBusiness rolePermissionsBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolePermissionsDto> create(@RequestBody Request<RolePermissionsDto> request) {
    	log.info("start method /rolePermissions/create");
        Response<RolePermissionsDto> response = controllerFactory.create(rolePermissionsBusiness, request, FunctionalityEnum.CREATE_ROLE_PERMISSIONS);
		log.info("end method /rolePermissions/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolePermissionsDto> update(@RequestBody Request<RolePermissionsDto> request) {
    	log.info("start method /rolePermissions/update");
        Response<RolePermissionsDto> response = controllerFactory.update(rolePermissionsBusiness, request, FunctionalityEnum.UPDATE_ROLE_PERMISSIONS);
		log.info("end method /rolePermissions/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolePermissionsDto> delete(@RequestBody Request<RolePermissionsDto> request) {
    	log.info("start method /rolePermissions/delete");
        Response<RolePermissionsDto> response = controllerFactory.delete(rolePermissionsBusiness, request, FunctionalityEnum.DELETE_ROLE_PERMISSIONS);
		log.info("end method /rolePermissions/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RolePermissionsDto> getByCriteria(@RequestBody Request<RolePermissionsDto> request) {
    	log.info("start method /rolePermissions/getByCriteria");
        Response<RolePermissionsDto> response = controllerFactory.getByCriteria(rolePermissionsBusiness, request, FunctionalityEnum.VIEW_ROLE_PERMISSIONS);
		log.info("end method /rolePermissions/getByCriteria");
        return response;
    }
}
