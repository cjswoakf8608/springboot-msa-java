package com.demo.project.coreusers.domain.service;

import com.demo.project.coreusers.domain.entity.MemberRoleEntity;
import com.demo.project.coreusers.domain.model.Search;
import org.springframework.data.domain.Page;

public interface MemberRolePersistenceInterface {
    Page<MemberRoleEntity> findAll(Search search);
}
