package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	public Message<?> print(Message<String> message) {
		System.out.println(message.getPayload());
		int messageNumber = (int) message.getHeaders().get("MessageNumber");
		return MessageBuilder.withPayload("Sending Reply for message : "+messageNumber).build();
	}

}
