
/*
 * Created on 2024-02-19 ( Time 10:54:59 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package dev.backend.epharmaApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//	@Autowired
//    private CustomInterceptor customInterceptor;

	@Autowired
	private SessionRenewalInterceptor sessionRenewalInterceptor;
	@Autowired ConnectionInterceptor connectionInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new RestInterceptor());

		registry.addInterceptor(sessionRenewalInterceptor).addPathPatterns("/**");
		// Ajout de l'intercepteur ConnectionInterceptor
		registry.addInterceptor(connectionInterceptor).addPathPatterns("/**");


	}


//	@Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // Enregistrer l'intercepteur
//        registry.addInterceptor(customInterceptor).addPathPatterns("/**");
//    }

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")  // Permet toutes les origines
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.allowedHeaders("*")
				.allowCredentials(false);  // Désactive les credentials
	}
}
