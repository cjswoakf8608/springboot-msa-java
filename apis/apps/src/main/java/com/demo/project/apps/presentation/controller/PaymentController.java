package com.demo.project.apps.presentation.controller;

import com.demo.project.apps.application.PaymentService;
import com.demo.project.apps.presentation.request.PaymentConfirmApiRequest;
import com.demo.project.apps.presentation.response.PaymentConfirmApiResponse;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import com.demo.project.globals.presentation.controller.BaseApiController;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping(value = "/v1/payments")
@RestController
public class PaymentController extends BaseApiController {
    private final PaymentService paymentService;

    @Operation(summary = "결제 승인", description = "결제를 승인합니다.")
    @PostMapping("/confirm/{memberId:[0-9]+}")
    public BaseApiResponse<PaymentConfirmApiResponse> confirmPayment(
            @PathVariable Long memberId,
            @RequestBody PaymentConfirmApiRequest request)
    {
        PaymentConfirmApiResponse response = paymentService.confirmPayment(memberId, request);

        return BaseApiResponse.success(response);
    }

}
