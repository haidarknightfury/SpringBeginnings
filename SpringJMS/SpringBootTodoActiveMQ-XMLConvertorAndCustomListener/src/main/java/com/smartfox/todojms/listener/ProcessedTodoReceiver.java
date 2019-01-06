package com.smartfox.todojms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Custom message listener - implement message listener 
 * annotate with @Component(Alternative - declare only bean in class) + JMSConfig
 */
public class ProcessedTodoReceiver implements MessageListener {
	@Override
	public void onMessage(Message message) {
		try {
			String text = ((TextMessage)message).getText();
			System.out.println(text);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
