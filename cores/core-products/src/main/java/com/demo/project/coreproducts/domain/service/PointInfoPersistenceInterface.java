package com.demo.project.coreproducts.domain.service;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import com.demo.project.coreproducts.domain.model.Search;
import org.springframework.data.domain.Page;

public interface PointInfoPersistenceInterface {
    Page<PointInfoEntity> findAll(Search search);
}
