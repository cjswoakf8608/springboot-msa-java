package com.demo.project.apps.infrastructure.integration.payments;

import com.demo.project.apps.domain.service.PaymentsIntegrationInterface;
import com.demo.project.apps.infrastructure.integration.payments.request.PaymentConfirmRequest;
import com.demo.project.apps.infrastructure.integration.payments.response.PaymentConfirmResponse;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PaymentsIntegrationAdapter implements PaymentsIntegrationInterface {
    private final PaymentsIntegrationClient paymentsIntegrationClient;

    @Override
    public PaymentConfirmResponse confirmPayment(PaymentConfirmRequest request) {
        ResponseEntity<BaseApiResponse<PaymentConfirmResponse>> response = paymentsIntegrationClient.confirmPayment(request);

        return Optional.ofNullable(response.getBody())
                .map(BaseApiResponse::getData)
                .orElse(null);
    }
}
