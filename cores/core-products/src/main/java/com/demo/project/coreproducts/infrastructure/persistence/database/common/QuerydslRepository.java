package com.demo.project.coreproducts.infrastructure.persistence.database.common;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class QuerydslRepository extends QuerydslRepositorySupport {
    public QuerydslRepository(Class<?> domainClass) {
        super(domainClass);
    }

    protected BooleanBuilder getQueryBuilder(List<BooleanExpression> items) {
        BooleanBuilder builder = new BooleanBuilder();
        items.forEach(builder::and);

        return builder;
    }
}
