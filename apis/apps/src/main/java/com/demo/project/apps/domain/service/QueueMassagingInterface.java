package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.messaging.request.PointSaveEvent;
import com.demo.project.apps.infrastructure.messaging.request.ProfileViewEvent;

public interface QueueMassagingInterface {
    void sendProfileView(ProfileViewEvent event);
    void sendPointSave(PointSaveEvent event);
}
