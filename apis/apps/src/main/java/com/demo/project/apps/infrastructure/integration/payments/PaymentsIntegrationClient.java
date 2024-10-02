package com.demo.project.apps.infrastructure.integration.payments;

import com.demo.project.apps.infrastructure.configuration.FeignConfig;
import com.demo.project.apps.infrastructure.integration.payments.request.PaymentConfirmRequest;
import com.demo.project.apps.infrastructure.integration.payments.response.PaymentConfirmResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="Payments", url="${externals.apis.api-network.payments.host}", configuration = {FeignConfig.class})
public interface PaymentsIntegrationClient {
    @PostMapping(value =
            "${externals.apis.api-network.payments.version}"
            + "${externals.apis.api-network.payments.uris.payments.resource}"
            + "${externals.apis.api-network.payments.uris.payments.api-confirm}"
    )
    ResponseEntity<BaseApiResponse<PaymentConfirmResponse>> confirmPayment(@RequestBody PaymentConfirmRequest request);
}
