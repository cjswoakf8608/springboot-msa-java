package com.demo.project.workers.infrastructure.persistence.database.impl;

import com.demo.project.workers.infrastructure.persistence.database.MemberJpaRepository;
import com.demo.project.workers.infrastructure.persistence.database.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Slf4j
@Repository
public class MemberJpaRepositoryImpl implements MemberJpaRepository {
	private final MemberRepository usersRepository;

    public MemberJpaRepositoryImpl(MemberRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

	@Override
	public void updateProfileView(Long memberId) {
		usersRepository.updateProfileView(memberId);
	}

	@Override
	public void savePoint(Long memberId, BigDecimal point) {
		usersRepository.updateProfileView(memberId, point);
	}
}
