package com.demo.project.workers.application;


import com.demo.project.workers.domain.annotations.DistributeLock;
import com.demo.project.workers.domain.service.MemberPersistenceService;
import com.demo.project.workers.domain.service.QueueMessagingService;
import com.demo.project.workers.infrastructure.messaging.request.ProfileViewEventDlq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfileViewService implements ProfileViewUseCase {
//	private final ProfileViewPersistenceService profileViewPersistenceService;
	private final MemberPersistenceService usersPersistenceService;
	private final QueueMessagingService queueMessagingService;

	@Override
	@Transient
//	@DistributeLock(prefix = "member", key = "#memberId")
	public void incrementTotalView(Long memberId) {
		// mongoDB에 조회수 증가 (원자성 보장 증가)
//		ProfileViewDocument profileViewDocument = profileViewPersistenceService.incrementTotalViewAndGet(memberId);
//		log.info("ProfileViewService.incrementTotalView memberId: {}, totalView: {}", memberId, profileViewDocument.getTotalView());

		// JPA로 조회수 증가
		usersPersistenceService.updateProfileView(memberId);
	}

	@Override
	public void sendProfileViewDlq(Long memberId) {
		// 에러가 발생한 데이터 DLQ로 전송
		queueMessagingService.sendProfileViewDlq(ProfileViewEventDlq.builder()
				.memberId(memberId)
				.build());
	}

//	@TransactionalWithLock(prefix = "charger", key = "#remoteTransaction.chargerId")
//    public ChargerByOccupiesDTO remoteStart(RemoteTransactionsDTO remoteTransaction) {
//        // 비즈니스 로직
//    }
}
