package com.demo.project.coreusers.application;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import com.demo.project.coreusers.domain.service.MemberPersistenceService;
import com.demo.project.coreusers.presentation.response.MemberResponse;
import com.demo.project.coreusers.presentation.response.MembersResponse;
import com.demo.project.coreusers.presentation.response.base.BaseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements MemberUseCase {
	private final MemberPersistenceService memberPersistenceService;

	@Override
	@Transactional(readOnly = true)
	public Optional<MemberEntity> getById(Long memberId) {
		return memberPersistenceService.findById(memberId);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<MemberEntity> getAll(Search search) {
		return memberPersistenceService.findAll(search);
	}

	@Override
	@Transactional
	public MemberResponse findById(Long memberId) {
		MemberEntity member = this.getById(memberId)
				.orElseThrow(() -> new BaseApiException(3000));

		return MemberResponse.response(member);
	}

	@Override
	@Transactional
	public MembersResponse findAll(Search search) {
		Page<MemberEntity> member = this.getAll(search);

		return MembersResponse.response(member);
	}
}
