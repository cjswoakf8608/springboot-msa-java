package com.demo.project.coreusers.infrastructure.persistence.database;

import com.demo.project.coreusers.domain.entity.MemberRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRoleJpaRepository extends JpaRepository<MemberRoleEntity, Long> {
}
