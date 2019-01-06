package com.smartfox.todojms.service;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartfox.todojms.pojo.TodoUser;
import com.smartfox.todojms.pojo.User;

@Service
public class TodoUserService {

	private static final String TODO_USER_QUEUE = "todo-user-queue";
	private static final String USER_QUEUE = "user-queue";

	@Autowired
	private JmsTemplate jmsTemplate;

	@Transactional
	public TodoUser send(TodoUser todoUser) {
		
		jmsTemplate.convertAndSend(TODO_USER_QUEUE, todoUser, new MessagePostProcessor() {// Access core JMSMessageObject - Add Custom Headers
			@Override
			public Message postProcessMessage(Message message) throws JMSException {
				// Custom header properties
				message.setStringProperty("todoid", todoUser.getTodo().getTodoID());
				message.setStringProperty("userid", todoUser.getUser().getUserId());
				message.setStringProperty("todostate", "notprocessed");
				return message;
			}
		});
		return todoUser;
	}
	
	

	@Transactional
	public User addUser(User user) {
		
		jmsTemplate.convertAndSend(USER_QUEUE, user, new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws JMSException {
				// Custom header properties
				message.setStringProperty("userid",user.getUserId());
				message.setStringProperty("userstate", "ADD");
				return message;
			}
		});
		return user;
	}
	

}
