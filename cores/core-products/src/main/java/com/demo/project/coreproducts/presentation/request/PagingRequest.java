package com.demo.project.coreproducts.presentation.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagingRequest {
    private Integer page;
    private Integer size;
    private List<String> sort;
}
