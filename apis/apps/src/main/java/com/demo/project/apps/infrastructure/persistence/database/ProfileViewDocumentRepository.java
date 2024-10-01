package com.demo.project.apps.infrastructure.persistence.database;

import com.demo.project.apps.domain.document.ProfileViewDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileViewDocumentRepository extends MongoRepository<ProfileViewDocument, String> {
}

