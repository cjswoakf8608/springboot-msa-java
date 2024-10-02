package com.demo.project.workers.domain.service;

import com.demo.project.workers.infrastructure.messaging.request.PointSaveEventDlq;
import com.demo.project.workers.infrastructure.messaging.request.ProfileViewEventDlq;

public interface QueueMassagingInterface {
    void sendProfileViewDlq(ProfileViewEventDlq event);
    void sendPointSaveDlq(PointSaveEventDlq event);
}
