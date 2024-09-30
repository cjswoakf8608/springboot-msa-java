package com.demo.project.workers.infrastructure.persistence.database;

import com.demo.project.workers.domain.document.ProfileViewDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileViewDocumentRepository extends MongoRepository<ProfileViewDocument, String> {
   ProfileViewDocument findByMemberId(Long memberPid);
}

