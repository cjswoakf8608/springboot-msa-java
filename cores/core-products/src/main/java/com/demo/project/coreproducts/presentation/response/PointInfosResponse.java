package com.demo.project.coreproducts.presentation.response;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@Schema(description = "포인트 정책 검색 응답")
public class PointInfosResponse {
    private List<PointInfoResponse> points;
    private PagingResponse pageable;

    public static PointInfosResponse response(Page<PointInfoEntity> entity) {
        return PointInfosResponse.builder()
                .points(entity.getContent().stream()
                        .map(PointInfoResponse::response)
                        .toList())
                .pageable(PagingResponse.response(entity))
                .build();
    }
}
