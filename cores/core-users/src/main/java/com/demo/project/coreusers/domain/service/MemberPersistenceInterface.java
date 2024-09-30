package com.demo.project.coreusers.domain.service;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberPersistenceInterface {
    Optional<MemberEntity> getById(Long memberId);
    Page<MemberEntity> findAll(Search search);
}
