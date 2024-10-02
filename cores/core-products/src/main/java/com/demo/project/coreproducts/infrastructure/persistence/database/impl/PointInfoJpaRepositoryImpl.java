package com.demo.project.coreproducts.infrastructure.persistence.database.impl;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import com.demo.project.coreproducts.domain.entity.QPointInfoEntity;
import com.demo.project.coreproducts.domain.model.Search;
import com.demo.project.coreproducts.infrastructure.persistence.database.PointInfoJpaRepository;
import com.demo.project.coreproducts.infrastructure.persistence.database.PointInfoRepository;
import com.demo.project.coreproducts.infrastructure.persistence.database.builder.QueryBuilderFactory;
import com.demo.project.coreproducts.infrastructure.persistence.database.common.QuerydslRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
public class PointInfoJpaRepositoryImpl extends QuerydslRepository implements PointInfoRepository {

	public PointInfoJpaRepositoryImpl() {
		super(PointInfoEntity.class);
    }

	/**
	 * 사용자 조건 검색
	 * 검색 조건 list(key, value) 기반 동적 Querydsl 생성
	 */
	@Override
	public Page<PointInfoEntity> findAll(Search search) {
		JPQLQuery<PointInfoEntity> query = from(QPointInfoEntity.pointInfoEntity);

		List<BooleanExpression> items = new QueryBuilderFactory()
				.createWhere("POINT_INFO")
				.where(search.getItems());

		query.where(super.getQueryBuilder(items));

		JPQLQuery<PointInfoEntity> pageableQuery = Objects.requireNonNull(getQuerydsl()).applyPagination(search.of(), query);
		List<PointInfoEntity> entities = pageableQuery.fetch();
		long total = query.fetchCount();

		return new PageImpl<>(entities, search.of(), total);
	}

}
