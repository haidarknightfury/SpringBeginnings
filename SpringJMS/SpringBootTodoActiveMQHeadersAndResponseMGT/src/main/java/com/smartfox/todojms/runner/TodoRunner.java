package com.smartfox.todojms.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.smartfox.todojms.sender.Sender;

@Component
public class TodoRunner implements ApplicationRunner {

	@Autowired
	Sender sender;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		sender.sendMessage("todo-queue", "hello world");
	}

}
