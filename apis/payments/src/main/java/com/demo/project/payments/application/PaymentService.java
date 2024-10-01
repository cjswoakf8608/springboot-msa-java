package com.demo.project.payments.application;

import com.demo.project.payments.domain.service.PaymentsIntegrationService;
import com.demo.project.payments.infrastructure.integration.payments.request.TossPaymentRequest;
import com.demo.project.payments.infrastructure.integration.payments.response.TossPaymentResponse;
import com.demo.project.payments.presentation.request.PaymentApiRequest;
import com.demo.project.payments.presentation.response.PaymentApiResponse;
import com.demo.project.payments.presentation.response.base.BaseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService implements PaymentUseCase {
    private final PaymentsIntegrationService paymentsIntegrationService;

	@Override
    public PaymentApiResponse confirmPayment(PaymentApiRequest request) {
        String paymentKey = request.getPaymentKey();
        String orderId = request.getOrderId();
        Integer amount = request.getAmount();

        TossPaymentResponse payment = paymentsIntegrationService.confirmPayment(TossPaymentRequest.builder()
                .paymentKey(paymentKey)
                .orderId(orderId)
                .amount(amount)
                .build());
		if (Objects.isNull(payment) || payment.isEmpty()) {
			throw new BaseApiException(300);
		}

		return PaymentApiResponse.response(payment);
    }

}
