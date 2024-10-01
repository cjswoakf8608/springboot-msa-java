package com.demo.project.workers.application;


import com.demo.project.workers.domain.document.ProfileViewDocument;
import com.demo.project.workers.domain.service.ProfileViewPersistenceService;
import com.demo.project.workers.domain.service.QueueMessagingService;
import com.demo.project.workers.infrastructure.messaging.request.ProfileViewEventDlq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfileViewService implements ProfileViewUseCase {
	private final ProfileViewPersistenceService profileViewPersistenceService;
	private final QueueMessagingService queueMessagingService;

	@Override
	public void incrementTotalView(Long memberId) {
		// mongoDB에 조회수 증가 (원자성 보장 증가)
		ProfileViewDocument profileViewDocument = profileViewPersistenceService.incrementTotalViewAndGet(memberId);
		log.info("ProfileViewService.incrementTotalView memberId: {}, totalView: {}", memberId, profileViewDocument.getTotalView());
	}

	@Override
	public void sendProfileViewDlq(Long memberId) {
		// 에러가 발생한 데이터 DLQ로 전송
		queueMessagingService.sendProfileViewDlq(ProfileViewEventDlq.builder()
				.memberId(memberId)
				.build());
	}
}
