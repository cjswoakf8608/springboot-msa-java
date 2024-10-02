package com.demo.project.apps.presentation.response;

import com.demo.project.apps.infrastructure.integration.payments.response.PaymentConfirmResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "결제 응답")
public class PaymentConfirmApiResponse {
    private String paymentKey;
    private String orderId;
    private String status;
    private String approvedAt;
    private Integer amount;

    public static PaymentConfirmApiResponse response(PaymentConfirmResponse payment) {
        return PaymentConfirmApiResponse.builder()
                .paymentKey(payment.getPaymentKey())
                .orderId(payment.getOrderId())
                .status(payment.getStatus())
                .approvedAt(payment.getApprovedAt())
                .amount(payment.getTotalAmount())
                .build();
    }
}
