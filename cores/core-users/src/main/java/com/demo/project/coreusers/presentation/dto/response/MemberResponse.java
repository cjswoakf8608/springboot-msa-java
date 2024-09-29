package com.demo.project.coreusers.presentation.dto.response;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.entity.MemberRoleEntity;
import com.demo.project.globals.domain.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "단일 사용자 응답")
public class MemberResponse {
    private String name;
    private Long totalView;
    private List<String> memberRoles;
    private MemberPointResponse memberPoint;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private String createdAt;

    public static MemberResponse response(MemberEntity entity) {
        List<String> memberRoles = entity.getMemberRoles()
                .stream()
                .map(MemberRoleEntity::getMemberRole)
                .toList();

        return MemberResponse.builder()
                .name(entity.getName())
                .totalView(entity.getTotalView())
                .memberRoles(memberRoles)
                .memberPoint(MemberPointResponse.response(entity.getMemberPoint()))
                .createdAt(DateTimeUtil.date2String(entity.getCreatedAt()))
                .build();
    }
}
