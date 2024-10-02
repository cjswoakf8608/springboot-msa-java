package com.demo.project.apps.infrastructure.integration.products.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointInfosResponse {
    private List<PointInfoResponse> points;
}
