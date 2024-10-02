package com.demo.project.apps.infrastructure.messaging.request;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class PointSaveEvent implements Serializable {
    private Long memberId;
    private BigDecimal point;
}
