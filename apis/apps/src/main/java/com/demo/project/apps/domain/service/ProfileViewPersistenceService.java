package com.demo.project.apps.domain.service;

import com.demo.project.apps.domain.document.ProfileViewDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ProfileViewPersistenceService {
	private final ProfileViewPersistenceInterface profileViewPersistenceInterface;

	public void save(ProfileViewDocument document) {
		profileViewPersistenceInterface.save(document);
	}
}


