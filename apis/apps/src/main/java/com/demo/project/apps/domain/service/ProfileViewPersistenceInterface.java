package com.demo.project.apps.domain.service;


import com.demo.project.apps.domain.document.ProfileViewDocument;

public interface ProfileViewPersistenceInterface {
    void save(ProfileViewDocument document);
}
