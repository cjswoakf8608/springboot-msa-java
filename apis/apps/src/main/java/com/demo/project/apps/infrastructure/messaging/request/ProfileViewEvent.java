package com.demo.project.apps.infrastructure.messaging.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProfileViewEvent implements Serializable {
    private Long memberId;
}
