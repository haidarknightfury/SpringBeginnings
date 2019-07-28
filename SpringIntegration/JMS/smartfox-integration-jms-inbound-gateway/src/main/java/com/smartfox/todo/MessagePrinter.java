package com.smartfox.todo;

import org.springframework.messaging.Message;

public class MessagePrinter {
	
	public String print(Message<?> message) {
		System.out.println(message);
		return "1 message worked";
	}
}
