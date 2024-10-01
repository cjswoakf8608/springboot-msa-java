package com.demo.project.apps.infrastructure.persistence.database.impl;

import com.demo.project.apps.domain.document.ProfileViewDocument;
import com.demo.project.apps.infrastructure.persistence.database.ProfileViewRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class ProfileViewDocumentRepositoryImpl implements ProfileViewRepository {
    protected final MongoTemplate mongoTemplate;


    @Override
    public void save(ProfileViewDocument document) {
        mongoTemplate.save(document);
        log.info("ProfileViewDocument saved");
    }
}
