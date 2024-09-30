package com.demo.project.apps.infrastructure.integration.users.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MembersResponse {
    private List<MemberResponse> members;
    private PagingResponse pageable;
}
