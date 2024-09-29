package com.demo.project.coreusers.presentation.dto.request;

import com.demo.project.coreusers.domain.model.Search;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Schema(description = "사용자 검색 조건")
public class SearchRequest extends PagingRequest {
    private List<String> searches;

    public Search toDto() {
        Search search = search();

        search.setPage(this.getPage());
        search.setSize(this.getSize());
        search.setSort(this.getSort());

        return search;
    }

    private Search search() {
        Search search = Search.builder().build();
        if (Objects.isNull(searches) || searches.isEmpty()) {
            return search;
        }

        searches.forEach(item -> {
            item = item.trim();
            String[] slitItem = item.split(":");
            search.of(slitItem[0], slitItem[1]);
        });
        return search;
    }
}
