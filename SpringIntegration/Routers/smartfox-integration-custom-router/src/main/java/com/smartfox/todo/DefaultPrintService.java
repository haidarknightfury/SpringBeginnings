package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class DefaultPrintService {

	public Message<?> print(Message<String> message) {
		System.out.println("DEFAULT : " + message.getPayload());
		return MessageBuilder.withPayload(message.getPayload()).build();
	}

}
