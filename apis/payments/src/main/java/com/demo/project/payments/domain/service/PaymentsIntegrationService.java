package com.demo.project.payments.domain.service;

import com.demo.project.payments.infrastructure.integration.payments.request.TossPaymentRequest;
import com.demo.project.payments.infrastructure.integration.payments.response.TossPaymentResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentsIntegrationService  {
	private final PaymentsIntegrationInterface paymentsIntegrationInterface;

	public TossPaymentResponse confirmPayment(TossPaymentRequest request) {
		return paymentsIntegrationInterface.confirmPayment(request);
	}

}

