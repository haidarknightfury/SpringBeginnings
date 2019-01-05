package com.smartfox.todojms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.smartfox.todojms.pojo.TodoUser;

@Service
public class TodoUserService {

	private static final String TODO_USER_QUEUE = "todo-user-queue";

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(TodoUser todoUser) {
		jmsTemplate.convertAndSend(TODO_USER_QUEUE, todoUser);
	}

}
