package com.smartfox.todo;

import java.util.Map;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

public class CustomAggregator extends AbstractAggregatingMessageGroupProcessor{

	@Override
	protected Object aggregatePayloads(MessageGroup group, Map<String, Object> defaultHeaders) {
		StringBuilder builder = new StringBuilder();
		for(Message<?> msg : group.getMessages()) {
				builder.append(msg.getPayload());
				System.out.println(msg.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID));
		}
		return builder.toString();
	}

}
