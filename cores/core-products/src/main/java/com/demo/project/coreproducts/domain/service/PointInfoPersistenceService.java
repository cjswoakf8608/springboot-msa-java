package com.demo.project.coreproducts.domain.service;

import com.demo.project.coreproducts.domain.entity.PointInfoEntity;
import com.demo.project.coreproducts.domain.model.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class PointInfoPersistenceService {
	private final PointInfoPersistenceInterface pointInfoPersistenceInterface;


	public Page<PointInfoEntity> findAll(Search search) {
		return pointInfoPersistenceInterface.findAll(search);
	}
}


