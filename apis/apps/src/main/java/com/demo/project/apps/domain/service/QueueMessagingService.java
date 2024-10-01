package com.demo.project.apps.domain.service;

import com.demo.project.apps.infrastructure.messaging.request.ProfileViewEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueueMessagingService {
	private final QueueMassagingInterface queueMassagingInterface;

	public void sendProfileView(ProfileViewEvent event) {
		queueMassagingInterface.sendProfileView(event);
	}
}


