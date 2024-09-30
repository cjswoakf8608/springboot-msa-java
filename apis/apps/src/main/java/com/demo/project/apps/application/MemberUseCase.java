package com.demo.project.apps.application;

import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.MemberApiResponse;
import com.demo.project.apps.presentation.response.MembersApiResponse;

public interface MemberUseCase {
    MemberApiResponse findById(Long memberId);
    MembersApiResponse findAll(SearchRequest request);
}
