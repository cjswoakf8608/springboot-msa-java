package com.demo.project.payments.infrastructure.integration.payments;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.util.Base64;

public class PaymentIntegrationHeader {

    private static final String WIDGET_SECRET_KEY = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";

    @Bean
    public RequestInterceptor requestCommonInterceptor() {
        return requestTemplate -> {
            String credentials = WIDGET_SECRET_KEY + ":";
            String encryptedSecretKey = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

            requestTemplate.header("Authorization", encryptedSecretKey);
            requestTemplate.header("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        };
    }
}
