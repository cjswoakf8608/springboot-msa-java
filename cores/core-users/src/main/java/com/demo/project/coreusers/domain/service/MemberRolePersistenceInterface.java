package com.demo.project.coreusers.domain.service;

import com.demo.project.coreusers.domain.entity.MemberRoleEntity;
import com.demo.project.coreusers.domain.model.Search;
import org.springframework.data.domain.Page;

// 로직에서 사용되진 않음
public interface MemberRolePersistenceInterface {
    Page<MemberRoleEntity> findAll(Search search);
}
