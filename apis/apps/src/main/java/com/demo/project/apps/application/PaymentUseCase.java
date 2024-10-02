package com.demo.project.apps.application;

import com.demo.project.apps.presentation.request.PaymentConfirmApiRequest;
import com.demo.project.apps.presentation.response.PaymentConfirmApiResponse;

public interface PaymentUseCase {
    PaymentConfirmApiResponse confirmPayment(Long memberId, PaymentConfirmApiRequest request);
}
