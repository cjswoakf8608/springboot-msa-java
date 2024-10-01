package com.demo.project.workers.presentation.consumer;

import com.demo.project.workers.application.ProfileViewService;
import com.demo.project.workers.presentation.request.ProfileViewEvent;
import com.demo.project.workers.presentation.response.base.BaseApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;



@Slf4j
@RequiredArgsConstructor
@Service
public class ProfileViewEventConsumer {
    private final ProfileViewService profileViewService;

    @KafkaListener(
            topics = "${spring.kafka.topic.profile-view}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "profileViewKafkaListenerContainerFactory" // KafkaListenerContainerFactory 설정으로 데이터 형식을 선변환
    )
    public void consume(@Payload ProfileViewEvent event, Acknowledgment acknowledgment) {
        try {
            log.info("ProfileViewEventConsumer: {}", event);
            profileViewService.incrementTotalView(event.getMemberId());
        } catch (BaseApiException e) {
            // 개발자가 예상하고 예외처리한 custom exception handling로 DLQ로 이동하지 않음
            log.error("BaseException[{}]: {}", e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
            profileViewService.sendProfileViewDlq(event.getMemberId());

        } finally {
            // 항상 ack를 보내서 Offset을 commit
            // Error가 발생하더라도 DLQ로 이동하기 때문에 Cluster 입장에서는 ack를 보내는 것이 좋음
            acknowledgment.acknowledge();
        }
    }

}
