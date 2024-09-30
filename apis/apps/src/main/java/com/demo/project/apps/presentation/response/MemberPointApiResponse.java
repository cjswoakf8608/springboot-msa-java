package com.demo.project.apps.presentation.response;

import com.demo.project.apps.infrastructure.integration.users.response.MemberPointResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@Schema(description = "단일 사용자 포인트 응답")
public class MemberPointApiResponse {
    private BigDecimal totalPoint;
    private BigDecimal usePoint;
    private BigDecimal remainPoint;

    public static MemberPointApiResponse response(MemberPointResponse response) {
        return MemberPointApiResponse.builder()
                .totalPoint(response.getTotalPoint())
                .usePoint(response.getUsePoint())
                .remainPoint(response.getRemainPoint())
                .build();
    }
}
