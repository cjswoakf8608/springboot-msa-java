package com.demo.project.apps.presentation.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "결제 요청")
public class PaymentConfirmApiRequest {
    private String paymentKey;
    private String orderId;
    private Integer amount;
}
