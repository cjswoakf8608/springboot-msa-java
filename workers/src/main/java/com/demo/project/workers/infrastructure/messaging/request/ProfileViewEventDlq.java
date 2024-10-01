package com.demo.project.workers.infrastructure.messaging.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProfileViewEventDlq implements Serializable {
    private Long memberId;
}
