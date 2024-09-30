package com.demo.project.apps.presentation.response;

import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "사용자 조건 겁색 응답")
public class MembersApiResponse {
    private List<MemberApiResponse> members;
    private PagingApiResponse pageable;

    public static MembersApiResponse response(MembersResponse response) {
        return MembersApiResponse.builder()
                .members(response.getMembers().stream()
                        .map(MemberApiResponse::response)
                        .toList())
                .pageable(PagingApiResponse.response(response.getPageable()))
                .build();
    }
}
