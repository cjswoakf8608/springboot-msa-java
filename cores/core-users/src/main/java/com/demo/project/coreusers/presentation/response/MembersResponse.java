package com.demo.project.coreusers.presentation.response;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@Schema(description = "사용자 검색 응답")
public class MembersResponse {
    private List<MemberResponse> members;
    private PagingResponse pageable;

    public static MembersResponse response(Page<MemberEntity> entity) {
        return MembersResponse.builder()
                .members(entity.getContent().stream()
                        .map(MemberResponse::response)
                        .toList())
                .pageable(PagingResponse.response(entity))
                .build();
    }
}
