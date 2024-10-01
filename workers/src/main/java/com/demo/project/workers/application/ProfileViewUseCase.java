package com.demo.project.workers.application;

public interface ProfileViewUseCase {
    void incrementTotalView(Long memberId);
    void sendProfileViewDlq(Long memberId);
}
