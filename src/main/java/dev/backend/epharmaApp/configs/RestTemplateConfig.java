package dev.backend.epharmaApp.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import dev.backend.epharmaApp.rest.SensitiveDataInterceptor;


import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(SensitiveDataInterceptor sensitiveDataInterceptor) {
        // Désactiver le mode streaming en utilisant BufferingClientHttpRequestFactory
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000); // Timeout pour la connexion
        requestFactory.setReadTimeout(5000);    // Timeout pour la lecture

        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(requestFactory));

        // Ajouter un gestionnaire d'erreurs personnalisé (optionnel)
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());

        // Ajouter l'intercepteur SensitiveDataInterceptor pour filtrer le PIN
        restTemplate.setInterceptors(Collections.singletonList(sensitiveDataInterceptor));

        return restTemplate;
    }
}
