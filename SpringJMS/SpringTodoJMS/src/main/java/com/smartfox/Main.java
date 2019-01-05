package com.smartfox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smartfox.config.AppConfig;
import com.smartfox.service.TodoService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		TodoService todoService = applicationContext.getBean(TodoService.class);
		todoService.getTodos().stream().forEach(System.out::println);
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
