package com.smartfox.todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class CustomRouter extends AbstractMessageRouter {

	@Autowired
	@Qualifier("intChannel")
	private MessageChannel intChannel;

	@Autowired
	@Qualifier("stringChannel")
	private MessageChannel stringChannel;

	@Autowired
	@Qualifier("defaultChannel")
	private MessageChannel defaultChannel;

	@Override
	protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {

		List<MessageChannel> targets = new ArrayList<MessageChannel>();
		if (message.getPayload().getClass().equals(Integer.class)) {
			targets.add(intChannel);
		}

		else if (message.getPayload().getClass().equals(String.class)) {
			targets.add(stringChannel);
		}
		else {
			targets.add(defaultChannel);
		}
		return targets;
	}

}
