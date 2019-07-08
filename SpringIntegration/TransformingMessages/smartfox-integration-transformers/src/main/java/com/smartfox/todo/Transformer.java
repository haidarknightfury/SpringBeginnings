package com.smartfox.todo;

import org.springframework.messaging.Message;

public class Transformer {
		
	public String transform(Message<String> message) {
		String tokens [] = message.getPayload().split(" ");
		return tokens[tokens.length- 1] + "," + tokens[tokens.length- 2];
	}
}
