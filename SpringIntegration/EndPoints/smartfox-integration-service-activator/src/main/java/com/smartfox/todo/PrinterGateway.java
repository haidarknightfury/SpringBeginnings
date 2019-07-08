package com.smartfox.todo;

import org.springframework.messaging.Message;

public interface PrinterGateway {
	// public Future<Message<String>> print(Message<?> message);
	public void print(Message<?> message);
}
