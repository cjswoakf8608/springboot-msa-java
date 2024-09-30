package com.demo.project.workers.domain.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseMongoDocument {

    @Id
    @Field(value = "_id", targetType = FieldType.OBJECT_ID)
    private ObjectId id;

    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Field("created_at")
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @Field("updated_at")
    @CreatedDate
    private LocalDateTime updatedAt = LocalDateTime.now();
}
