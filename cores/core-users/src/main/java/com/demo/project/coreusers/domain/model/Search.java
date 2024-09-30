package com.demo.project.coreusers.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Search extends Paging {
    @Builder.Default
    private List<SearchItem> items = new ArrayList<>();

    public void of(String key, String value) {
        SearchItem searchItem = SearchItem.builder()
                .key(key)
                .value(value)
                .build();
        items.add(searchItem);
    }
}
