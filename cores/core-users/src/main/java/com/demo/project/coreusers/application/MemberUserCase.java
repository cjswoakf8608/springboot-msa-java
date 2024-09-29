package com.demo.project.coreusers.application;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.presentation.dto.response.MemberResponse;

import java.util.Optional;

public interface MemberUserCase {
    Optional<MemberEntity> getById(Long memberId);
    MemberResponse findById(Long memberId);
}
