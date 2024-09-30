package com.demo.project.apps.infrastructure.integration.users.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagingResponse {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}
