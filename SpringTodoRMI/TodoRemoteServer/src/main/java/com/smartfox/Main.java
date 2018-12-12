package com.smartfox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smartfox.config.AppConfig;
import com.smartfox.service.TodoService;

public class Main {

    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TodoService service = context.getBean(TodoService.class);
        service.create("hello", "world");
        System.out.println(service.find("hello"));

    }

}
