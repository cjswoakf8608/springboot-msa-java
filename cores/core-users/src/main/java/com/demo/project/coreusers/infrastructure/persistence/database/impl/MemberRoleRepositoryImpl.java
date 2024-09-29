package com.demo.project.coreusers.infrastructure.persistence.database.impl;

import com.demo.project.coreusers.domain.entity.MemberRoleEntity;
import com.demo.project.coreusers.domain.entity.QMemberRoleEntity;
import com.demo.project.coreusers.domain.model.Search;
import com.demo.project.coreusers.infrastructure.persistence.database.MemberRoleRepository;
import com.demo.project.coreusers.infrastructure.persistence.database.builder.QueryBuilderFactory;
import com.demo.project.coreusers.infrastructure.persistence.database.common.QuerydslRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class MemberRoleRepositoryImpl extends QuerydslRepository implements MemberRoleRepository {

	public MemberRoleRepositoryImpl() {
		super(MemberRoleEntity.class);
	}

	/**
	 * 사용자 Role 조건 검색
	 * 검색 조건 list(key, value) 기반 동적 Querydsl 생성
	 */
	@Override
	public Page<MemberRoleEntity> findAll(Search search) {
		JPQLQuery<MemberRoleEntity> query = from(QMemberRoleEntity.memberRoleEntity);

		List<BooleanExpression> items = new QueryBuilderFactory()
				.createWhere("MEMBER_ROLE")
				.where(search.getItems());

		query.where(super.getQueryBuilder(items));

		JPQLQuery<MemberRoleEntity> pageableQuery = Objects.requireNonNull(getQuerydsl()).applyPagination(search.of(), query);
		List<MemberRoleEntity> entities = pageableQuery.fetch();
		long total = query.fetchCount();

		return new PageImpl<>(entities, search.of(), total);
	}

}
