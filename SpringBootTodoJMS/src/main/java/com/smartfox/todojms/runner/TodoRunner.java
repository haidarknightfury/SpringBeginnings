package com.smartfox.todojms.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoRunner implements ApplicationRunner {

	@Autowired
	ApplicationContext context;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("todo-queue", "hello world");
	}

}
