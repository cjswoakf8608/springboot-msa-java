package com.demo.project.workers.infrastructure.messaging;

import com.demo.project.workers.domain.service.QueueMassagingInterface;
import com.demo.project.workers.infrastructure.messaging.request.ProfileViewEventDlq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MessageProducerAdapter implements QueueMassagingInterface {
    private final MessageProducer messageProducer;

    @Override
    public void sendProfileViewDlq(ProfileViewEventDlq event) {
        messageProducer.sendEvent("com.demo.project.profile.view.topic.dlq", event);
    }

    // 각 TOPIC 별로 메시지 전송 메서드 추가
}
