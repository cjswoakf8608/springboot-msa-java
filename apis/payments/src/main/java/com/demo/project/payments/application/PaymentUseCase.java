package com.demo.project.payments.application;

import com.demo.project.payments.presentation.request.PaymentApiRequest;
import com.demo.project.payments.presentation.response.PaymentApiResponse;

public interface PaymentUseCase {
    PaymentApiResponse confirmPayment(PaymentApiRequest request);
}
