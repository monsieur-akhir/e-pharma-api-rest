

/*
 * Java controller for entity table client_roles 
 * Created on 2025-02-15 ( Time 03:02:41 )
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
Controller for table "client_roles"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/clientRoles")
public class ClientRolesController {

	@Autowired
    private ControllerFactory<ClientRolesDto> controllerFactory;
	@Autowired
	private ClientRolesBusiness clientRolesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientRolesDto> create(@RequestBody Request<ClientRolesDto> request) {
    	log.info("start method /clientRoles/create");
        Response<ClientRolesDto> response = controllerFactory.create(clientRolesBusiness, request, FunctionalityEnum.CREATE_CLIENT_ROLES);
		log.info("end method /clientRoles/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientRolesDto> update(@RequestBody Request<ClientRolesDto> request) {
    	log.info("start method /clientRoles/update");
        Response<ClientRolesDto> response = controllerFactory.update(clientRolesBusiness, request, FunctionalityEnum.UPDATE_CLIENT_ROLES);
		log.info("end method /clientRoles/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientRolesDto> delete(@RequestBody Request<ClientRolesDto> request) {
    	log.info("start method /clientRoles/delete");
        Response<ClientRolesDto> response = controllerFactory.delete(clientRolesBusiness, request, FunctionalityEnum.DELETE_CLIENT_ROLES);
		log.info("end method /clientRoles/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ClientRolesDto> getByCriteria(@RequestBody Request<ClientRolesDto> request) {
    	log.info("start method /clientRoles/getByCriteria");
        Response<ClientRolesDto> response = controllerFactory.getByCriteria(clientRolesBusiness, request, FunctionalityEnum.VIEW_CLIENT_ROLES);
		log.info("end method /clientRoles/getByCriteria");
        return response;
    }
}
