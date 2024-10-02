package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.SearchRequest;

public interface UsersIntegrationInterface {
    MembersResponse findAll(SearchRequest searchRequest);
}
