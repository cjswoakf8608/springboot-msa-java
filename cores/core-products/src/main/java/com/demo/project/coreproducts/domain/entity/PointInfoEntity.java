package com.demo.project.coreproducts.domain.entity;

import com.demo.project.coreproducts.domain.constant.PointInfoRdbConstant;
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
@Table(name = "point_info")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction("status != 'D'")
@SQLDelete(sql = "UPDATE point_info SET status = 'D' WHERE id = ?")
@EqualsAndHashCode(callSuper = false)
public class PointInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "point_ratio", nullable = false, precision = 10, scale = 3)
    private BigDecimal pointRatio;

    @Column(name = "point_type", length = 100, unique = true)
    private String pointType;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private String status = PointInfoRdbConstant.STATUS_ACTIVE;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
