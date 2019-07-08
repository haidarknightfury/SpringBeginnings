package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	
	// Accept a msg of any type
	public void print(Message<?> message) {
		message.getHeaders().entrySet().forEach(entry->{
			System.out.println(entry.getKey()+":"+entry.getValue());
		});
		System.out.println("MSG : " +message.getPayload());
	}

}
