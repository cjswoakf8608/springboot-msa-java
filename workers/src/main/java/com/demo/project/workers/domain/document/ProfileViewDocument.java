package com.demo.project.workers.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Document(collection = "profile_view")
public class ProfileViewDocument extends BaseMongoDocument {
    private Long memberId;
    private Long totalView;
}
