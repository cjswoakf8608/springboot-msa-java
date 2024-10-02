package com.demo.project.apps.infrastructure.integration.users;

import com.demo.project.apps.domain.service.UsersIntegrationInterface;
import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UsersIntegrationAdapter implements UsersIntegrationInterface {
    private final UsersIntegrationClient usersIntegrationClient;

    @Override
    public MembersResponse findAll(SearchRequest searchRequest) {
        ResponseEntity<BaseApiResponse<MembersResponse>> response = usersIntegrationClient.findAll(searchRequest);
        return Optional.ofNullable(response.getBody())
                .map(BaseApiResponse::getData)
                .orElse(null);
    }


}
