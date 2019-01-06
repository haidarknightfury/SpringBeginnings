package com.smartfox.todojms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Sender {

	@Autowired
	JmsTemplate jmsTemplate;

	/**
	 * Active mq server must be started
	 */
	@Transactional
	public void sendMessage(String destination, String message) {
		this.jmsTemplate.convertAndSend(destination, message);
	}
}
