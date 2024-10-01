package com.demo.project.workers.infrastructure.messaging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Slf4j
@AllArgsConstructor
@Repository
public class MessageProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public <T> void sendEvent(String topic, T data) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, data);
        future.whenComplete((result, e) -> {
            if (e != null) {
                e.printStackTrace();
            } else {
                log.info("Sent message=[{}] with offset=[{}]", data, result.getRecordMetadata().offset());
            }
        });
    }
}
