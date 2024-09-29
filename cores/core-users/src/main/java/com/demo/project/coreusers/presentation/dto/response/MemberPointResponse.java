package com.demo.project.coreusers.presentation.dto.response;

import com.demo.project.coreusers.domain.entity.MemberPointEntity;
import com.demo.project.coreusers.domain.entity.MemberRoleEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

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
