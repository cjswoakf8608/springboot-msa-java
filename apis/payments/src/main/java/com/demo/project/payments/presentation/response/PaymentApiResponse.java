package com.demo.project.payments.presentation.response;

import com.demo.project.payments.infrastructure.integration.payments.response.TossPaymentResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "결제 응답")
public class PaymentApiResponse {
    private String paymentKey;
    private String orderId;
    private String status;
    private String approvedAt;
    private Integer amount;

    public static PaymentApiResponse response(TossPaymentResponse payment) {
        return PaymentApiResponse.builder()
                .paymentKey(payment.getPaymentKey())
                .orderId(payment.getOrderId())
                .status(payment.getStatus())
                .approvedAt(payment.getApprovedAt())
                .amount(payment.getTotalAmount())
                .build();
    }
}
