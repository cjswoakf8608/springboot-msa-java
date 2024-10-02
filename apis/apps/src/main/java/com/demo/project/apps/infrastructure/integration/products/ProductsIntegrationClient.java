package com.demo.project.apps.infrastructure.integration.products;

import com.demo.project.apps.infrastructure.configuration.FeignConfig;
import com.demo.project.apps.infrastructure.integration.products.response.PointInfosResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Products", url="${externals.apis.core-network.products.host}", configuration = {FeignConfig.class})
public interface ProductsIntegrationClient {
    @GetMapping(value =
            "${externals.apis.core-network.products.version}"
            + "${externals.apis.core-network.products.uris.points.resource}"
    )
    ResponseEntity<BaseApiResponse<PointInfosResponse>> findPointInfos(@SpringQueryMap SearchRequest request);
}
