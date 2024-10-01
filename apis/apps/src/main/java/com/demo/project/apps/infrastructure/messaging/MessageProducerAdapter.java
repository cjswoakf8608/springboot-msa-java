package com.demo.project.apps.infrastructure.messaging;

import com.demo.project.apps.domain.service.QueueMassagingInterface;
import com.demo.project.apps.infrastructure.messaging.request.ProfileViewEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MessageProducerAdapter implements QueueMassagingInterface {
    private final MessageProducer messageProducer;

    @Override
    public void sendProfileView(ProfileViewEvent event) {
        messageProducer.sendEvent("com.demo.project.profile.view.topic", event);
    }

    // 각 TOPIC 별로 메시지 전송 메서드 추가
}
