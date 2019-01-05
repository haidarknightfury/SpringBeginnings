package com.smartfox.todojms.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.smartfox.todojms.pojo.ProcessedTodoUser;
import com.smartfox.todojms.pojo.TodoUser;

@Service
public class ProcessedTodoUserService {

	@Autowired
	public JmsTemplate jmsTemplate;
	
	public void processTodoUser(TodoUser todoUser) {
		ProcessedTodoUser processedTodoUser = new  ProcessedTodoUser(todoUser, LocalDate.now());
		this.jmsTemplate.convertAndSend("todo-processed-queue", processedTodoUser);
	}
	
}
