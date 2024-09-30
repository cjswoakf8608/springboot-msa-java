package com.demo.project.apps.presentation.response;

import com.demo.project.apps.infrastructure.integration.users.response.PagingResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "검색 페이지 네이션")
public class PagingApiResponse {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    public static PagingApiResponse response(PagingResponse response) {
        return PagingApiResponse.builder()
                .pageNumber(response.getPageNumber())
                .pageSize(response.getPageSize())
                .totalElements(response.getTotalElements())
                .totalPages(response.getTotalPages())
                .build();
    }
}
