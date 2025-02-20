

/*
 * Java controller for entity table notices 
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
Controller for table "notices"
 * 
 * @author SFL Back-End developper
 *
 */
@Log
@CrossOrigin("*")
@RestController
@RequestMapping(value="/notices")
public class NoticesController {

	@Autowired
    private ControllerFactory<NoticesDto> controllerFactory;
	@Autowired
	private NoticesBusiness noticesBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<NoticesDto> create(@RequestBody Request<NoticesDto> request) {
    	log.info("start method /notices/create");
        Response<NoticesDto> response = controllerFactory.create(noticesBusiness, request, FunctionalityEnum.CREATE_NOTICES);
		log.info("end method /notices/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<NoticesDto> update(@RequestBody Request<NoticesDto> request) {
    	log.info("start method /notices/update");
        Response<NoticesDto> response = controllerFactory.update(noticesBusiness, request, FunctionalityEnum.UPDATE_NOTICES);
		log.info("end method /notices/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<NoticesDto> delete(@RequestBody Request<NoticesDto> request) {
    	log.info("start method /notices/delete");
        Response<NoticesDto> response = controllerFactory.delete(noticesBusiness, request, FunctionalityEnum.DELETE_NOTICES);
		log.info("end method /notices/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<NoticesDto> getByCriteria(@RequestBody Request<NoticesDto> request) {
    	log.info("start method /notices/getByCriteria");
        Response<NoticesDto> response = controllerFactory.getByCriteria(noticesBusiness, request, FunctionalityEnum.VIEW_NOTICES);
		log.info("end method /notices/getByCriteria");
        return response;
    }
}
