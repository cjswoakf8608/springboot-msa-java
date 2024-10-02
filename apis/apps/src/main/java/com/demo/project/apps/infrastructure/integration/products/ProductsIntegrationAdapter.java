package com.demo.project.apps.infrastructure.integration.products;

import com.demo.project.apps.domain.service.PaymentsIntegrationInterface;
import com.demo.project.apps.domain.service.ProductsIntegrationInterface;
import com.demo.project.apps.infrastructure.integration.products.response.PointInfosResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductsIntegrationAdapter implements ProductsIntegrationInterface {
    private final ProductsIntegrationClient productsIntegrationClient;

    @Override
    public PointInfosResponse findPointInfos(SearchRequest request) {
        ResponseEntity<BaseApiResponse<PointInfosResponse>> response = productsIntegrationClient.findPointInfos(request);

        return Optional.ofNullable(response.getBody())
                .map(BaseApiResponse::getData)
                .orElse(null);
    }
}
