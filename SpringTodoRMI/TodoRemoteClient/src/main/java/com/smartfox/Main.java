package com.smartfox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smartfox.config.AppConfig;
import com.smartfox.service.impl.TodoConsumerServiceImpl;

public class Main {

    /**
     * Client uses a proxy factory bean for communication
     * All the Naming and Bind are done automatically by Spring
     * Only need to autowire the TodoService and use normally
     */

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TodoConsumerServiceImpl service = context.getBean(TodoConsumerServiceImpl.class);
        service.find();

        ((ConfigurableApplicationContext) context).close();
    }
}
