package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.integration.products.response.PointInfosResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductsIntegrationService {
	private final ProductsIntegrationInterface productsIntegrationInterface;

	public PointInfosResponse findPointInfos(SearchRequest request){
		return productsIntegrationInterface.findPointInfos(request);
	}
}

