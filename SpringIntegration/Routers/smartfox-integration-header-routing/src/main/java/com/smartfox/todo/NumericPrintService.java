package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class NumericPrintService {
	
	public Message<?> print(Message<String> message) {
		System.out.println("NUMERICE SERVICE : "+message.getPayload().toUpperCase());
		int messageNumber = (int) message.getHeaders().get("MessageNumber");
		return MessageBuilder.withPayload("Sending Reply for message : ".toUpperCase()+messageNumber).build();
	}

}
