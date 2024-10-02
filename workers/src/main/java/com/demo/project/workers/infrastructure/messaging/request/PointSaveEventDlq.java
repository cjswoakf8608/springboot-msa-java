package com.demo.project.workers.infrastructure.messaging.request;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class PointSaveEventDlq implements Serializable {
    private Long memberId;
    private BigDecimal point;
}
