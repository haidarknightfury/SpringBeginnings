package com.smartfox.todojms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TodoReceiver {
	
	/**
	 * Only one jms listener for a queue 
	 */
	@JmsListener(destination="todo-queue", containerFactory="warehouseFactory") // 2nd parameter - Queue on which MOM resides
	public void receiveMessage(String message) {
		System.out.println("Todo received is "+ message);
	}

}
