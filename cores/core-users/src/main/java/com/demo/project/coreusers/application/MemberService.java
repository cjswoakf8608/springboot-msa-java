package com.demo.project.coreusers.application;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import com.demo.project.coreusers.domain.service.MemberPersistenceService;
import com.demo.project.coreusers.presentation.dto.response.MemberResponse;
import com.demo.project.coreusers.presentation.dto.response.base.BaseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements MemberUserCase {
	private final MemberPersistenceService memberPersistenceService;

	@Override
	@Transactional(readOnly = true)
	public Optional<MemberEntity> getById(Long memberId) {
		return memberPersistenceService.findById(memberId);
	}

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

	@Transactional
	public Page<MemberResponse> findAll(Search search) {
		Page<MemberEntity> member = this.getAll(search);

		return new PageImpl<>(member.getContent().stream()
				.map(MemberResponse::response)
				.collect(Collectors.toList()), search.of(), member.getTotalElements());
	}
}
