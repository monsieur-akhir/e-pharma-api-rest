package dev.backend.epharmaApp.rest;


import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SensitiveDataInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Remplacer le PIN par **** dans les journaux
        String sanitizedUri = request.getURI().toString().replaceAll("pin=\\d+", "pin=****");

        // Afficher uniquement l'URI nettoyé
        System.out.println("Request URI: " + sanitizedUri);

        return execution.execute(request, body);
    }
}
