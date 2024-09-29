package com.demo.project.coreusers.domain.service;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import com.demo.project.coreusers.presentation.dto.request.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberPersistenceService  {
	private final MemberPersistenceInterface memberPersistenceInterface;

	public MemberPersistenceService(MemberPersistenceInterface memberPersistenceInterface) {
		this.memberPersistenceInterface = memberPersistenceInterface;
	}

	public Optional<MemberEntity> findById(Long memberId) {
		return memberPersistenceInterface.getById(memberId);
	}

	public Page<MemberEntity> findAll(Search search) {
		return memberPersistenceInterface.findAll(search);
	}
}
