package com.demo.project.workers.domain.service;
import java.math.BigDecimal;

public interface MemberPersistenceInterface {
    void updateProfileView(Long memberId);
    void savePoint(Long memberId, BigDecimal point);
}
