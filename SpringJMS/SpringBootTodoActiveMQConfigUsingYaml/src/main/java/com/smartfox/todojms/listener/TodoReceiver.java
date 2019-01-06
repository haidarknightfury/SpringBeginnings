package com.smartfox.todojms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.smartfox.todojms.pojo.Todo;
import com.smartfox.todojms.pojo.TodoUser;

@Component
public class TodoReceiver {
	
	/**
	 * Only one jms listener for a queue  - use default
	 */
	@JmsListener(destination="todo-queue") // connection factory not specified - use default JMS Factory configured in config
	public void receiveMessage(String message) {
		System.out.println("Todo received is "+ message);
	}
	
	@JmsListener(destination = "todo-user-queue") // automatically picks up transactional management - no need to specify @transactional
	public void receiveTodoUserMessage(TodoUser todoUser) {
		// Simulating error
		if(!todoUser.getUser().getUsername().equals("baka")) {
			throw new RuntimeException("user name not valid -  should be baka");
		}
		System.out.println(todoUser);
	}

}
