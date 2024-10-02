package com.demo.project.workers.presentation.consumer;

import com.demo.project.workers.application.MemberService;
import com.demo.project.workers.presentation.request.PointSaveEvent;
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
public class PointSaveEventConsumer {
    private final MemberService memberService;

    @KafkaListener(
            topics = "${spring.kafka.topic.point-save}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "pointSaveKafkaListenerContainerFactory" // KafkaListenerContainerFactory 설정으로 데이터 형식을 선변환
    )
    public void consume(@Payload PointSaveEvent event, Acknowledgment acknowledgment) {
        try {
            log.info("PointSaveEventConsumer: {}", event);
            memberService.savePoint(event.getMemberId(), event.getPoint());
        } catch (BaseApiException e) {
            // 개발자가 예상하고 예외처리한 custom exception handling로 DLQ로 이동하지 않음
            log.error("BaseException[{}]: {}", e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
            memberService.sendPointSaveDlq(event.getMemberId(), event.getPoint());

        } finally {
            // 항상 ack를 보내서 Offset을 commit
            // Error가 발생하더라도 DLQ로 이동하기 때문에 Cluster 입장에서는 ack를 보내는 것이 좋음
            acknowledgment.acknowledge();
        }
    }

}
