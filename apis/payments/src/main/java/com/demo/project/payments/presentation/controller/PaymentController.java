package com.demo.project.payments.presentation.controller;

import com.demo.project.globals.presentation.controller.BaseApiController;
import com.demo.project.payments.application.PaymentService;
import com.demo.project.payments.presentation.request.PaymentApiRequest;
import com.demo.project.payments.presentation.response.PaymentApiResponse;
import com.demo.project.payments.presentation.response.base.BaseApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping(value = "/v1/payments")
@RestController
public class PaymentController extends BaseApiController {
    private final PaymentService paymentService;

    @Operation(summary = "결제 승인", description = "결제를 승인합니다.")
    @PostMapping("/confirm")
    public BaseApiResponse<PaymentApiResponse> confirmPayment(@RequestBody PaymentApiRequest request) {
        PaymentApiResponse response = paymentService.confirmPayment(request);

        return BaseApiResponse.success(response);
    }

}
