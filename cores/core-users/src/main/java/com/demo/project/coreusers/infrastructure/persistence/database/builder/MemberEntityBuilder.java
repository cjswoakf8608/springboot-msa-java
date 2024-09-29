package com.demo.project.coreusers.infrastructure.persistence.database.builder;

import com.demo.project.coreusers.domain.model.SearchItem;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.demo.project.coreusers.domain.entity.QMemberEntity.memberEntity;

public class MemberEntityBuilder implements QueryBuilder {

    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";

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
            case FIELD_ID -> memberEntity.id.eq(Long.valueOf(value));
            case FIELD_NAME -> memberEntity.name.eq(value);
            default -> null;
        };
    }
}
