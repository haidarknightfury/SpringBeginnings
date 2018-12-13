package com.smartfox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smartfox.config.AppConfig;
import com.smartfox.service.TodoService;

public class Main {

    /**
     * RMI is an excellent way to communicate with remote services, but it has some limi-
     * tations. First, RMI has difficulty working across firewalls. That’s because RMI uses arbi-
     * trary ports for communication—something that firewalls typically don’t allow
     *
     * Server exports the RMI Bean- in AppConfig
     */

    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TodoService service = context.getBean(TodoService.class);
        service.create("hello", "world");
        System.out.println(service.find("hello"));
    }

}
