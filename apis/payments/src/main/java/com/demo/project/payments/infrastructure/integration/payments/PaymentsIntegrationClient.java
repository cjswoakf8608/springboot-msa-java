package com.demo.project.payments.infrastructure.integration.payments;

import com.demo.project.payments.infrastructure.configuration.PaymentFeignErrorDecoder;
import com.demo.project.payments.infrastructure.integration.payments.request.TossPaymentRequest;
import com.demo.project.payments.infrastructure.integration.payments.response.TossPaymentResponse;
import com.demo.project.payments.presentation.response.base.BaseApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tosspayments", url = "https://api.tosspayments.com" ,configuration = {PaymentFeignErrorDecoder.class, PaymentIntegrationHeader.class})
public interface PaymentsIntegrationClient {

    @PostMapping("/v1/payments/confirm")
    ResponseEntity<BaseApiResponse<TossPaymentResponse>> confirmPayment(@RequestBody TossPaymentRequest requestBody);
}
