
/*
 * Created on 2024-02-19 ( Time 10:54:59 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.contract;

import dev.backend.epharmaApp.utils.contract.IBasicBusiness;
import dev.backend.epharmaApp.utils.contract.Request;
import dev.backend.epharmaApp.utils.contract.Response;
import dev.backend.epharmaApp.utils.enums.FunctionalityEnum;

/**
 * IController
 * 
 * @author Geo
 *
 */
public interface IController<DTO> {
    Response<DTO> create(IBasicBusiness iBasicBusiness, dev.backend.epharmaApp.utils.contract.Request<DTO> request, FunctionalityEnum functionalityEnum);

    Response<DTO> update(IBasicBusiness iBasicBusiness, dev.backend.epharmaApp.utils.contract.Request<DTO> request, FunctionalityEnum functionalityEnum);

    Response<DTO> delete(IBasicBusiness iBasicBusiness, dev.backend.epharmaApp.utils.contract.Request<DTO> request, FunctionalityEnum functionalityEnum);

    Response<DTO> getByCriteria(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum);
}

