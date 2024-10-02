package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.integration.payments.request.PaymentConfirmRequest;
import com.demo.project.apps.infrastructure.integration.payments.response.PaymentConfirmResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.PaymentConfirmApiRequest;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.PaymentConfirmApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentsIntegrationService {
	private final PaymentsIntegrationInterface paymentsIntegrationInterface;

	public PaymentConfirmResponse confirmPayment(PaymentConfirmRequest request) {
		return paymentsIntegrationInterface.confirmPayment(request);
	}
}

