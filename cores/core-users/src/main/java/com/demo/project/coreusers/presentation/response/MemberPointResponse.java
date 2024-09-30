package com.demo.project.coreusers.presentation.response;

import com.demo.project.coreusers.domain.entity.MemberPointEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@Schema(description = "단일 사용자 포인트 응답")
public class MemberPointResponse {
    private BigDecimal totalPoint;
    private BigDecimal usePoint;
    private BigDecimal remainPoint;

    public static MemberPointResponse response(MemberPointEntity entity) {
        return MemberPointResponse.builder()
                .totalPoint(entity.getTotalPoint())
                .usePoint(entity.getUsePoint())
                .remainPoint(entity.getRemainPoint())
                .build();
    }
}
