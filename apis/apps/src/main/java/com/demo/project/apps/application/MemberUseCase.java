package com.demo.project.apps.application;

import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.MemberApiResponse;
import com.demo.project.apps.presentation.response.MembersApiResponse;

public interface MemberUseCase {
    MembersResponse getById(Long memberId);
    MemberApiResponse findById(Long memberId);
    MembersApiResponse findAll(SearchRequest request);
}
