package com.demo.project.coreusers.domain.service;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberPersistenceInterface {
    Page<MemberEntity> findAll(Search search);
}
