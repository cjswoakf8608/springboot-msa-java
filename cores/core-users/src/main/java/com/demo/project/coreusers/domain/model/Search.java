package com.demo.project.coreusers.domain.model;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.entity.MemberRoleEntity;
import com.demo.project.coreusers.presentation.dto.request.PagingRequest;
import com.demo.project.coreusers.presentation.dto.response.MemberPointResponse;
import com.demo.project.coreusers.presentation.dto.response.MemberResponse;
import com.demo.project.globals.domain.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
