package com.demo.project.apps.application;

import com.demo.project.apps.domain.document.ProfileViewDocument;
import com.demo.project.apps.domain.service.ProfileViewPersistenceService;
import com.demo.project.apps.domain.service.UsersIntegrationService;
import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.MemberApiResponse;
import com.demo.project.apps.presentation.response.MembersApiResponse;
import com.demo.project.apps.presentation.response.base.BaseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements MemberUseCase {
	private final UsersIntegrationService usersIntegrationService;
	private final ProfileViewPersistenceService profileViewPersistenceService;

	@Override
	public MemberApiResponse findById(Long memberId) {
		// Users MSA로 사용자 조회
		MemberResponse member = usersIntegrationService.findById(memberId);
		if (Objects.isNull(member)) {
			throw new BaseApiException(300);
		}

		// mongoDB에 조회수 증가 (원자성 보장 증가)
		ProfileViewDocument profileViewDocument = profileViewPersistenceService.incrementTotalViewAndGet(memberId);
		member.setTotalView(profileViewDocument.getTotalView());

		return MemberApiResponse.response(member);
	}

	public MembersApiResponse findAll(SearchRequest request) {
		MembersResponse members = usersIntegrationService.findAll(request);
		if (Objects.isNull(members)) {
			throw new BaseApiException(301);
		}

		return MembersApiResponse.response(members);
	}
}
