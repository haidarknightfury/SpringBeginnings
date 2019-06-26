package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	public Message<?> print(Message<String> message) {
		
		// If one service down,-> all the msgs routed to other service end point
		//throw new RuntimeException("An error");
		
		System.out.println("PRINT SERVICE : "+ message.getPayload());
		int messageNumber = (int) message.getHeaders().get("MessageNumber");
		return MessageBuilder.withPayload("Sending Reply for message : "+messageNumber).build();
	}

}
