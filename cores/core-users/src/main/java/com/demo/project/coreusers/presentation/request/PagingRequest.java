package com.demo.project.coreusers.presentation.request;

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
