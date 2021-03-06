package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	public Message<?> print(Message<String> message) {
		message.getHeaders().entrySet().forEach(entry->{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		});
		
		return MessageBuilder.withPayload("New Message").build();
	}

}
