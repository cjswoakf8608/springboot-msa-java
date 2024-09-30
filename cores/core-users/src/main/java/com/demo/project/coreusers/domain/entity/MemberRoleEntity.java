package com.demo.project.coreusers.domain.entity;

import com.demo.project.coreusers.domain.constant.MemberRdbConstant;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Slf4j
@Builder
@Entity
@Getter
@Table(name = "member_role")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction("status != 'D'")
@SQLDelete(sql = "UPDATE member_role SET status = 'D' WHERE id = ?")
@EqualsAndHashCode(callSuper = false)
public class MemberRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity member;

    @Column(name = "member_role", length = 100)
    private String memberRole;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private String status = MemberRdbConstant.STATUS_ACTIVE;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
