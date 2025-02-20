/*
* Created on 2024-12-19 ( Time 23:37:09 )
* Generator tool : Telosys Tools Generator ( version 3.3.0 )
* Copyright 2018 Geo. All Rights Reserved.
*/

package dev.backend.epharmaApp.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Geo
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                        .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
         Collection<VendorExtension> vendorExtensions = new ArrayList<>();
         vendorExtensions.add( new StringVendorExtension("owner", "Backend-REST"));
         vendorExtensions.add( new StringVendorExtension("development_team", "Backend-REST"));

         Contact contactInfo = new Contact("Perform", "http://www.google.com","tsegbas@gmail.com");
         return new ApiInfo(
             "Perform API",
             "API REST ",
             "1.0",
             "",
             contactInfo,
             "OpenSource - Apache 2.0",
             "http://www.apache.org",
             vendorExtensions);
       }
}
