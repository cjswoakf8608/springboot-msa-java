package com.demo.project.workers.application;

import java.math.BigDecimal;

public interface MemberUseCase {
    void incrementTotalView(Long memberId);
    void sendProfileViewDlq(Long memberId);
    void savePoint(Long memberId, BigDecimal point);
    void sendPointSaveDlq(Long memberId, BigDecimal point);
}
