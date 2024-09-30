package com.demo.project.coreproducts.domain.model;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class Paging {

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 10;
    private static final String DEFAULT_SORT = "id";
    private static final String DEFAULT_DIRECTION = "desc";

    private Integer page;
    private Integer size;
    private List<String> sort;

    public Pageable of() {
        return PageRequest.of(
                Optional.ofNullable(page).orElse(DEFAULT_PAGE) - 1,
                Optional.ofNullable(size).orElse(DEFAULT_SIZE),
                sort()
        );
    }

    private Sort sort() {
        if (Objects.isNull(sort) || sort.isEmpty()) {
            return Sort.by(Sort.Direction.fromString(DEFAULT_DIRECTION), DEFAULT_SORT);
        }

        List<Sort.Order> orders = sort.stream()
                .map(item -> {
                    String[] splitItem = item.split(":");
                    return new Sort.Order(direction(splitItem[1]), splitItem[0]);
                })
                .collect(Collectors.toList());

        return Sort.by(orders);
    }

    private Sort.Direction direction(String direction) {
        return Optional.ofNullable(direction)
                .map(Sort.Direction::fromString)
                .orElse(Sort.Direction.fromString(DEFAULT_DIRECTION));
    }

}
