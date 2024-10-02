package com.demo.project.apps.infrastructure.integration.users.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class MembersResponse {
    private List<MemberResponse> members;
    private PagingResponse pageable;

    public MembersResponse(List<MemberResponse> members) {
        this.members = members;
    }
}
