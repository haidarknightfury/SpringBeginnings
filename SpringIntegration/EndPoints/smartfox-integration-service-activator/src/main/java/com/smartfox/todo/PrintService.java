package com.smartfox.todo;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {
	
	public void print(Message<String> message) {
		message.getHeaders().entrySet().forEach(entry->{
			System.out.println(entry.getKey()+":"+entry.getValue());
		});
		System.out.println("MSG : " +message.getPayload());
	}

}
