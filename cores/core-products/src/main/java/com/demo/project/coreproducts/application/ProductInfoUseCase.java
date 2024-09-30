package com.demo.project.coreproducts.application;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import com.demo.project.coreproducts.presentation.response.PointInfosResponse;
import com.demo.project.coreproducts.domain.model.Search;
import org.springframework.data.domain.Page;

public interface ProductInfoUseCase {
    Page<PointInfoEntity> getAll(Search search);
    PointInfosResponse findAll(Search search);
}
