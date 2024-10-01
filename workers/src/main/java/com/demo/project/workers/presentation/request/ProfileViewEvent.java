package com.demo.project.workers.presentation.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProfileViewEvent implements Serializable {
    private Long memberId;
}
