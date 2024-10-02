package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.integration.products.response.PointInfosResponse;
import com.demo.project.apps.presentation.request.SearchRequest;

public interface ProductsIntegrationInterface {
    PointInfosResponse findPointInfos(SearchRequest request);
}
