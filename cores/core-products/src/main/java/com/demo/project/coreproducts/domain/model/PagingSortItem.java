package com.demo.project.coreproducts.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagingSortItem {
    private String property;
    private String direction;


}
