package com.demo.project.coreusers.infrastructure.persistence.database.impl;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.entity.QMemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import com.demo.project.coreusers.infrastructure.persistence.database.MemberRepository;
import com.demo.project.coreusers.infrastructure.persistence.database.builder.QueryBuilderFactory;
import com.demo.project.coreusers.infrastructure.persistence.database.common.QuerydslRepository;
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
public class MemberJpaRepositoryImpl extends QuerydslRepository implements MemberRepository {

	public MemberJpaRepositoryImpl() {
		super(MemberEntity.class);
    }

	/**
	 * 사용자 조건 검색
	 * 검색 조건 list(key, value) 기반 동적 Querydsl 생성
	 */
	@Override
	public Page<MemberEntity> findAll(Search search) {
		JPQLQuery<MemberEntity> query = from(QMemberEntity.memberEntity);

		List<BooleanExpression> items = new QueryBuilderFactory()
				.createWhere("MEMBER")
				.where(search.getItems());

		query.where(super.getQueryBuilder(items));

		JPQLQuery<MemberEntity> pageableQuery = Objects.requireNonNull(getQuerydsl()).applyPagination(search.of(), query);
		List<MemberEntity> entities = pageableQuery.fetch();
		long total = query.fetchCount();

		return new PageImpl<>(entities, search.of(), total);
	}

}
