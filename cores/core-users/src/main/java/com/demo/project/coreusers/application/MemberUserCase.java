package com.demo.project.coreusers.application;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import com.demo.project.coreusers.presentation.response.MemberResponse;
import com.demo.project.coreusers.presentation.response.MembersResponse;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberUserCase {
    Optional<MemberEntity> getById(Long memberId);
    Page<MemberEntity> getAll(Search search);
    MemberResponse findById(Long memberId);
    MembersResponse findAll(Search search);
}
