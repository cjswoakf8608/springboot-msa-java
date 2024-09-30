package com.demo.project.apps.infrastructure.integration.users.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MemberPointResponse {
    private BigDecimal totalPoint;
    private BigDecimal usePoint;
    private BigDecimal remainPoint;
}
