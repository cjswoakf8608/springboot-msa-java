package com.demo.project.apps.infrastructure.integration.users.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPointResponse {
    private BigDecimal totalPoint;
}
