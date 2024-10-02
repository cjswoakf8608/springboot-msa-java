package com.demo.project.apps.infrastructure.integration.products.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointInfoResponse {
    private BigDecimal pointRatio;
    private String pointType;
}
