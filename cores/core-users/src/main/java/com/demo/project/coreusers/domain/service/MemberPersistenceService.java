package com.demo.project.coreusers.domain.service;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import com.demo.project.coreusers.domain.model.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MemberPersistenceService  {
	private final MemberPersistenceInterface memberPersistenceInterface;

	public Page<MemberEntity> findAll(Search search) {
		return memberPersistenceInterface.findAll(search);
	}
}


