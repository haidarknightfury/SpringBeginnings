package com.smartfox;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smartfox.config.TodoConfig;
import com.smartfox.service.TodoService;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TodoConfig.class);
        TodoService service = context.getBean(TodoService.class);
        service.saveTodo("first", "body");

        System.out.println(service.findOne("first"));

        service.saveTodoUnless("second", "secondbody"); // Not saved unless cacheable set to true
        System.out.println(service.findOne("second"));

        service.saveTodoCondition("x", "xbody");// Not saved into cache - because of condition
        System.out.println(service.findOne("x"));

        service.saveTodoCondition("xyzabc", "xbody");
        System.out.println(service.findOne("xyzabc"));

        service.removeFromCache("xyzabc");
        System.out.println(service.findOne("xyzabc"));

    }
}
