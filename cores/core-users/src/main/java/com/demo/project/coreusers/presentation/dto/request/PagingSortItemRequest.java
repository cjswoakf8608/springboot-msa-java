package com.demo.project.coreusers.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "사용자 검색 조건 페이징 property, direction")
public class PagingSortItemRequest {
    private String property;
    private String direction;


}
