package com.demo.project.coreproducts.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchItem {
    private String key;
    private String value;
}



