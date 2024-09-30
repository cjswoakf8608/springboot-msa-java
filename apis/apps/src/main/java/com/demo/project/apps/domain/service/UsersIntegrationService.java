package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersIntegrationService  {
	private final UsersIntegrationInterface usersIntegrationInterface;

	public MemberResponse findById(Long memberId) {
		return usersIntegrationInterface.findById(memberId);
	}

	public MembersResponse findAll(SearchRequest request) {
		return usersIntegrationInterface.findAll(request);
	}
}

