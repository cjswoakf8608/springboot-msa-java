package com.demo.project.coreproducts.infrastructure.persistence.database.builder;

import com.demo.project.coreproducts.domain.model.SearchItem;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.demo.project.coreproducts.domain.entity.QPointInfoEntity.pointInfoEntity;

public class PointInfoEntityBuilder implements QueryBuilder {

    private static final String FIELD_ID = "id";
    private static final String FIELD_POINT_TYPE = "pointType";

    @Override
    public List<BooleanExpression> where(List<SearchItem> items) {
        return items.stream()
                .map(item -> this.whereExpression(item.getKey(), item.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public BooleanExpression whereExpression(String key, String value) {
        if (BooleanUtils.isFalse(StringUtils.hasText(value))) {
            return null;
        }

        return switch (key) {
            case FIELD_ID -> pointInfoEntity.id.eq(Long.valueOf(value));
            case FIELD_POINT_TYPE -> pointInfoEntity.pointType.eq(value);
            default -> null;
        };
    }
}
