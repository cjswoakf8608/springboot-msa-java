package com.demo.project.coreusers.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Builder
@Entity
@Getter
@Table(name = "member_point")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction("status != 'D'")
@SQLDelete(sql = "UPDATE member_point SET status = 'D' WHERE id = ?")
@EqualsAndHashCode(callSuper = false)
public class MemberPointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity member;

    @Column(name = "total_point", precision = 10, scale = 2)
    private BigDecimal totalPoint;

    @Column(name = "use_point", precision = 10, scale = 2)
    private BigDecimal usePoint;

    @Column(name = "remain_point", precision = 10, scale = 2)
    private BigDecimal remainPoint;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private String status = "A";

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
