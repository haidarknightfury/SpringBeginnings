package com.smartfox.todojms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	JmsTemplate jmsTemplate;

	/**
	 * Active mq server must be started
	 */
	public void sendMessage(String destination, String message) {
		this.jmsTemplate.convertAndSend(destination, message);
	}
}
