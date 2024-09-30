package com.demo.project.coreproducts.infrastructure.persistence.database;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointInfoRepository extends JpaRepository<PointInfoEntity, Long> {
}
