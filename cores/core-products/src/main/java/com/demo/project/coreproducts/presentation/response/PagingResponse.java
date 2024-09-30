package com.demo.project.coreproducts.presentation.response;


import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@Builder
@Schema(description = "검색 페이지 네이션")
public class PagingResponse {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    public static PagingResponse response(Page<PointInfoEntity> entity) {
        return PagingResponse.builder()
                .pageNumber(entity.getNumber() + 1)
                .pageSize(entity.getSize())
                .totalElements(entity.getTotalElements())
                .totalPages(entity.getTotalPages())
                .build();
    }
}
