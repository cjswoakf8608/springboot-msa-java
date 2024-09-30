package com.demo.project.apps.presentation.request;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class SearchRequest extends PagingRequest {
    private List<String> searches;
}
