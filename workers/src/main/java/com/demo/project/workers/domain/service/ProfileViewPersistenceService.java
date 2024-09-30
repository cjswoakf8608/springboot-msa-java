package com.demo.project.workers.domain.service;

import com.demo.project.workers.domain.document.ProfileViewDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ProfileViewPersistenceService {
	private final ProfileViewPersistenceInterface profileViewPersistenceInterface;

	public ProfileViewDocument findById(Long memberId) {
		return profileViewPersistenceInterface.getById(memberId);
	}

	public void save(ProfileViewDocument document) {
		profileViewPersistenceInterface.save(document);
	}

	public ProfileViewDocument incrementTotalViewAndGet(Long memberId) {
		ProfileViewDocument profileViewDocument = this.findById(memberId);
		if (Objects.isNull(profileViewDocument)) {
			this.save(ProfileViewDocument.builder()
					.memberId(memberId)
					.build());
		}
		return profileViewPersistenceInterface.incrementTotalViewAndGet(memberId);
	}
}


