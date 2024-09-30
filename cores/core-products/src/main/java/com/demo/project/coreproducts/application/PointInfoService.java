package com.demo.project.coreproducts.application;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import com.demo.project.coreproducts.domain.service.PointInfoPersistenceService;


import com.demo.project.coreproducts.presentation.response.PointInfosResponse;
import com.demo.project.coreproducts.domain.model.Search;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PointInfoService implements ProductInfoUseCase {
	private final PointInfoPersistenceService pointInfoPersistenceService;

	@Override
	@Transactional(readOnly = true)
	public Page<PointInfoEntity> getAll(Search search) {
		return pointInfoPersistenceService.findAll(search);
	}


	@Override
	@Transactional
	public PointInfosResponse findAll(Search search) {
		Page<PointInfoEntity> pointInfo = this.getAll(search);

		return PointInfosResponse.response(pointInfo);
	}
}
