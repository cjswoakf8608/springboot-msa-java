package com.demo.project.workers.infrastructure.persistence.database;

import com.demo.project.workers.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE MemberEntity m SET m.totalView = m.totalView + 1 WHERE m.id = :memberId")
    void updateProfileView(Long memberId);
}
