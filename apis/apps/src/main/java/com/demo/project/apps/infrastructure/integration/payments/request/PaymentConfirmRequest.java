package com.demo.project.apps.infrastructure.integration.payments.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentConfirmRequest {

    @Schema(description = "결제의 키 값", example = "k7Z3y47BMw6", required = true, maxLength = 200)
    private String paymentKey;

    @Schema(description = "주문 번호", example = "ORDER123456", required = true, minLength = 6, maxLength = 64)
    private String orderId;

    @Schema(description = "결제할 금액", example = "10000", required = true)
    private Integer amount;
}
