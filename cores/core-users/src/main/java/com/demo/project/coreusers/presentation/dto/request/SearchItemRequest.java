package com.demo.project.coreusers.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "사용자 검색 조건 key, value")
public class SearchItemRequest {
    private String key;
    private String value;


}
