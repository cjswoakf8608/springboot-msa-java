package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.integration.payments.request.PaymentConfirmRequest;
import com.demo.project.apps.infrastructure.integration.payments.response.PaymentConfirmResponse;
import com.demo.project.apps.presentation.request.PaymentConfirmApiRequest;
import com.demo.project.apps.presentation.response.PaymentConfirmApiResponse;

public interface PaymentsIntegrationInterface {
    PaymentConfirmResponse confirmPayment(PaymentConfirmRequest request);
}
