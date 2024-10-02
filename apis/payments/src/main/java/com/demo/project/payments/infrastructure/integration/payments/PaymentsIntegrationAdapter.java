package com.demo.project.payments.infrastructure.integration.payments;

import com.demo.project.payments.domain.service.PaymentsIntegrationInterface;
import com.demo.project.payments.infrastructure.integration.payments.request.TossPaymentRequest;
import com.demo.project.payments.infrastructure.integration.payments.response.TossPaymentResponse;
import com.demo.project.payments.presentation.response.base.BaseApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Base64;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PaymentsIntegrationAdapter implements PaymentsIntegrationInterface {
    private final PaymentsIntegrationClient paymentsIntegrationClient;

    private final String secretKey = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";

    @Override
    public TossPaymentResponse confirmPayment(TossPaymentRequest request) {
        // PaymentFeignErrorDecoder 에서 에러 처리됨
        ResponseEntity<BaseApiResponse<TossPaymentResponse>> response = paymentsIntegrationClient.confirmPayment(request);

        return Optional.ofNullable(response.getBody())
                .map(BaseApiResponse::getData)
                .orElse(null);
    }


}
