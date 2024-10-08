package com.demo.project.apps.application;

import com.demo.project.apps.domain.document.ProfileViewDocument;
import com.demo.project.apps.domain.service.ProfileViewPersistenceService;
import com.demo.project.apps.domain.service.QueueMessagingService;
import com.demo.project.apps.domain.service.UsersIntegrationService;
import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.infrastructure.messaging.request.ProfileViewEvent;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.MemberApiResponse;
import com.demo.project.apps.presentation.response.MembersApiResponse;
import com.demo.project.apps.presentation.response.base.BaseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements MemberUseCase {
	private final UsersIntegrationService usersIntegrationService;
	private final ProfileViewPersistenceService profileViewPersistenceService;
	private final QueueMessagingService queueMessagingService;

	@Override
	public MembersResponse getById(Long memberId) {
		// Users MSA로 사용자 조회
		return usersIntegrationService.findAll(SearchRequest.builder()
				.searches(Collections.singletonList("id:" + memberId))
				.build());
	}

	@Override
	public MemberApiResponse findById(Long memberId) {
		MembersResponse members = this.getById(memberId);
		if (Objects.isNull(members) || members.getMembers().isEmpty()) {
			throw new BaseApiException(300);
		}
		MemberResponse member = members.getMembers().get(0);

		// mongoDB에 프로필 조회 이벤트 저장 (아카이브)
		profileViewPersistenceService.save(ProfileViewDocument.builder()
				.memberId(memberId)
				.build());


		// Kafka로 프로필 조회 이벤트 발송
		queueMessagingService.sendProfileView(ProfileViewEvent.builder()
				.memberId(memberId)
				.build());

		return MemberApiResponse.response(member);
	}

	@Override
	public MembersApiResponse findAll(SearchRequest request) {
		MembersResponse members = usersIntegrationService.findAll(request);
		if (Objects.isNull(members)) {
			throw new BaseApiException(301);
		}

		return MembersApiResponse.response(members);
	}
}
