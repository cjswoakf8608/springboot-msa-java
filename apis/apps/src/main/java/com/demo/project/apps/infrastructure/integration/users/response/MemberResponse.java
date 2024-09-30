package com.demo.project.apps.infrastructure.integration.users.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MemberResponse {
    private Long id;
    private String name;
    private Long totalView;
    private List<String> memberRoles;
    private MemberPointResponse memberPoint;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private String createdAt;
}
