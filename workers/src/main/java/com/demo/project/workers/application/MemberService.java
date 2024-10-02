package com.demo.project.workers.application;


import com.demo.project.workers.domain.annotations.DistributeLock;
import com.demo.project.workers.domain.service.MemberPersistenceService;
import com.demo.project.workers.domain.service.QueueMessagingService;
import com.demo.project.workers.infrastructure.messaging.request.PointSaveEventDlq;
import com.demo.project.workers.infrastructure.messaging.request.ProfileViewEventDlq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements MemberUseCase {
	private final MemberPersistenceService memberPersistenceService;
	private final QueueMessagingService queueMessagingService;

	@Override
	@Transient
	@DistributeLock(prefix = "member", key = "#memberId") // 분산 락
	public void incrementTotalView(Long memberId) {
		// JPA로 조회수 증가
		memberPersistenceService.updateProfileView(memberId);
	}

	@Override
	public void sendProfileViewDlq(Long memberId) {
		// 에러가 발생한 데이터 DLQ로 전송
		queueMessagingService.sendProfileViewDlq(ProfileViewEventDlq.builder()
				.memberId(memberId)
				.build());
	}

	@Override
	@Transient
	@DistributeLock(prefix = "member_point", key = "#memberId") // 분산 락
	public void savePoint(Long memberId, BigDecimal point) {
		// JPA로 조회수 증가
		memberPersistenceService.savePoint(memberId, point);
	}

	@Override
	public void sendPointSaveDlq(Long memberId, BigDecimal point) {
		// 에러가 발생한 데이터 DLQ로 전송
		queueMessagingService.sendPointSaveDlq(PointSaveEventDlq.builder()
				.memberId(memberId)
				.point(point)
				.build());
	}
}

//sendPointSaveDlq(Long memberId, BigDecimal point)
