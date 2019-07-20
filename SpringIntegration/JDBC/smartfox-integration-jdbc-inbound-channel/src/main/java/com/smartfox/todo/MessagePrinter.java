package com.smartfox.todo;

import org.springframework.messaging.Message;

public class MessagePrinter {
	
	public void print(Message<?> message) {
		System.out.println(message);
	}
}
