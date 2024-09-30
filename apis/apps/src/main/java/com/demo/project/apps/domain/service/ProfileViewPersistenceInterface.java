package com.demo.project.apps.domain.service;

import com.demo.project.apps.domain.document.ProfileViewDocument;

public interface ProfileViewPersistenceInterface {
    ProfileViewDocument getById(Long memberId);
    void save(ProfileViewDocument document);
    ProfileViewDocument incrementTotalViewAndGet(Long memberId);
}
