package com.demo.project.coreproducts.presentation.response;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@Schema(description = "포인트 정책 정보 응답")
public class PointInfoResponse {
    private BigDecimal pointRatio;
    private String pointType;

    public static PointInfoResponse response(PointInfoEntity entity) {
        return PointInfoResponse.builder()
                .pointRatio(entity.getPointRatio())
                .pointType(entity.getPointType())
                .build();
    }
}
