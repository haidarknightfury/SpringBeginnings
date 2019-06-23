package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;

public class CustomChannelInterceptor implements ChannelInterceptor {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		Message msg = MessageBuilder.fromMessage(message).
				withPayload(message.getPayload().toString()+ "intercepted").
				copyHeaders(message.getHeaders()).build();
		return ChannelInterceptor.super.preSend(msg, channel);
	}
	

}
