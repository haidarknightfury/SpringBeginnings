package com.smartfox.todo;

import org.springframework.messaging.Message;

public class MessagePrinter {
	
	public String print(Message<?> message) {
		System.out.println(message);
		return "From the Inbound gateway : 1 message worked";
	}
	
	public void printConsole(Message<?> message) {
		System.out.println("Messaged was passed to print console from outbound gateway");
		System.out.println(message.getPayload());
	}
}
