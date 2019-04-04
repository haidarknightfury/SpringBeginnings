package com.smartfox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smartfox.config.AppConfig;
import com.smartfox.service.TodoServiceCaller;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TodoServiceCaller todoServiceCaller = applicationContext.getBean(TodoServiceCaller.class);
        todoServiceCaller.run();
    }

}
