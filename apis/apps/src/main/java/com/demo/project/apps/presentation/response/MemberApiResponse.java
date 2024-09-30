package com.demo.project.apps.presentation.response;

import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "단일 사용자 응답")
public class MemberApiResponse {
    private Long id;
    private String name;
    private Long totalView;
    private List<String> memberRoles;
    private MemberPointApiResponse memberPoint;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private String createdAt;

    public static MemberApiResponse response(MemberResponse response) {
        return MemberApiResponse.builder()
                .id(response.getId())
                .name(response.getName())
                .totalView(response.getTotalView())
                .memberRoles(response.getMemberRoles())
                .memberPoint(MemberPointApiResponse.response(response.getMemberPoint()))
                .createdAt(response.getCreatedAt())
                .build();
    }
}
