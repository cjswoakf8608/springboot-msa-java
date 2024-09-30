package com.demo.project.apps.infrastructure.persistence.database.impl;

import com.demo.project.apps.domain.document.ProfileViewDocument;
import com.demo.project.apps.infrastructure.persistence.database.ProfileViewDocumentRepository;
import com.demo.project.apps.infrastructure.persistence.database.ProfileViewRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileViewRepositoryImpl implements ProfileViewRepository {
    private final MongoTemplate mongoTemplate;
    private final ProfileViewDocumentRepository profileViewDocumentRepository;

    public ProfileViewRepositoryImpl(ProfileViewDocumentRepository profileViewDocumentRepository, MongoTemplate mongoTemplate) {
        this.profileViewDocumentRepository = profileViewDocumentRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ProfileViewDocument getById(Long memberId) {
        return profileViewDocumentRepository.findByMemberId(memberId);
    }

    @Override
    public void save(ProfileViewDocument document) {
        profileViewDocumentRepository.save(document);
    }

    /**
     * 원자성 보장 +1 증가
     */
    @Override
    public ProfileViewDocument incrementTotalViewAndGet(Long memberId) {
        Query query = new Query(Criteria.where("memberId").is(memberId));
        Update update = new Update().inc("totalView", 1);
        return mongoTemplate.findAndModify(query, update, ProfileViewDocument.class);
    }
}
