
/*
 * Java dto for entity table users 
 * Created on 2025-02-15 ( Time 03:02:48 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package dev.backend.epharmaApp.utils.dto.customize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * DTO customize for table "users"
 * 
 * @author Geo
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class _UsersDto {

    private String token;
    private String refreshToken;

}
