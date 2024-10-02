package com.demo.project.workers.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class MemberPersistenceService {
	private final MemberPersistenceInterface memberPersistenceInterface;

	public void updateProfileView(Long memberId) {
		memberPersistenceInterface.updateProfileView(memberId);
	}

	public void savePoint(Long memberId, BigDecimal point) {
		memberPersistenceInterface.savePoint(memberId, point);
	}
}


