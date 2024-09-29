package com.demo.project.coreusers.infrastructure.persistence.database;

import com.demo.project.coreusers.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}
