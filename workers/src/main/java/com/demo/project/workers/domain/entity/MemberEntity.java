package com.demo.project.workers.domain.entity;

import com.demo.project.workers.domain.constant.MemberRdbConstant;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Builder
@Entity
@Getter
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction("status != 'D'")
@SQLDelete(sql = "UPDATE member SET status = 'D' WHERE id = ?")
@EqualsAndHashCode(callSuper = false)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id", nullable = false, length = 320)
    private String loginId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(name = "total_view")
    private Long totalView;

    @Column(length = 100)
    private String name;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private String status = MemberRdbConstant.STATUS_ACTIVE;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MemberPointEntity memberPoint;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MemberRoleEntity> memberRoles = new ArrayList<>();
}
