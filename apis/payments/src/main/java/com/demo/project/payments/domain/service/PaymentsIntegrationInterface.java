package com.demo.project.payments.domain.service;

import com.demo.project.payments.infrastructure.integration.payments.request.TossPaymentRequest;
import com.demo.project.payments.infrastructure.integration.payments.response.TossPaymentResponse;

public interface PaymentsIntegrationInterface {
    TossPaymentResponse confirmPayment(TossPaymentRequest request);
}
