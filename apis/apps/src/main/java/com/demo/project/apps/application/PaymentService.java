package com.demo.project.apps.application;

import com.demo.project.apps.domain.service.PaymentsIntegrationService;
import com.demo.project.apps.domain.service.ProductsIntegrationService;
import com.demo.project.apps.domain.service.QueueMessagingService;
import com.demo.project.apps.infrastructure.integration.payments.response.PaymentConfirmResponse;
import com.demo.project.apps.infrastructure.integration.products.response.PointInfosResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.infrastructure.messaging.request.PointSaveEvent;
import com.demo.project.apps.presentation.request.PaymentConfirmApiRequest;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.PaymentConfirmApiResponse;
import com.demo.project.apps.presentation.response.base.BaseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService implements PaymentUseCase {
	private final PaymentsIntegrationService paymentsIntegrationService;
	private final ProductsIntegrationService productsIntegrationService;
	private final QueueMessagingService queueMessagingService;
	private final MemberService memberService;

	@Override
	public PaymentConfirmApiResponse confirmPayment(Long memberId, PaymentConfirmApiRequest request) {
		// 사용자 검증
		MembersResponse members = memberService.getById(memberId);
		if (Objects.isNull(members) || members.getMembers().isEmpty()) {
			throw new BaseApiException(300);
		}

		// Payments MSA에 결제 확인
		String paymentKey = request.getPaymentKey();
		String orderId = request.getOrderId();
		Integer amount = request.getAmount();
//		PaymentConfirmResponse payment = paymentsIntegrationService.confirmPayment(PaymentConfirmRequest.builder()
//				.paymentKey(paymentKey)
//				.orderId(orderId)
//				.amount(amount)
//				.build());
//		if (Objects.isNull(payment) || payment.isEmpty()) {
//			throw new BaseApiException(3000);
//		}

		PointInfosResponse points = productsIntegrationService.findPointInfos(SearchRequest.builder()
				.searches(Collections.singletonList("pointType:" + "PURCHASE_POINT"))
				.build());
		if (BooleanUtils.isFalse(Objects.isNull(points) || points.getPoints().isEmpty())) {
			BigDecimal pointRatio = points.getPoints().get(0).getPointRatio();
			BigDecimal pointSave = BigDecimal.valueOf(request.getAmount()).multiply(pointRatio);


			// Kafka로 적립 이벤트 발송
			queueMessagingService.sendPointSave(PointSaveEvent.builder()
					.memberId(memberId)
					.point(pointSave)
					.build());
		}

		return PaymentConfirmApiResponse.response(PaymentConfirmResponse.builder().build());
	}
}
