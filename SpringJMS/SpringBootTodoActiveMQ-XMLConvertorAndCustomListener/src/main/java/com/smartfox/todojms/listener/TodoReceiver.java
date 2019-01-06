package com.smartfox.todojms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

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
	
	@JmsListener(destination = "todo-user-queue")
	public void receiveTodoUserMessage(TodoUser todoUser) {
		System.out.println(todoUser);
	}

}
