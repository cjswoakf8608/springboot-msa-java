package com.demo.project.coreusers.infrastructure.persistence.database.builder;

import com.demo.project.coreusers.domain.model.SearchItem;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;

public interface QueryBuilder {
    List<BooleanExpression> where(List<SearchItem> items);
    BooleanExpression whereExpression(String key, String value);
}


