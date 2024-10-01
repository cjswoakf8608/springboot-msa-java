package com.demo.project.workers.domain.service;

import com.demo.project.workers.infrastructure.messaging.request.ProfileViewEventDlq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueueMessagingService {
	private final QueueMassagingInterface queueMassagingInterface;

	public void sendProfileViewDlq(ProfileViewEventDlq event) {
		queueMassagingInterface.sendProfileViewDlq(event);
	}
}


