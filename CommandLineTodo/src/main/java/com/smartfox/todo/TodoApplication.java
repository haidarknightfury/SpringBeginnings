package com.smartfox.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.smartfox.todo.service.TodoService;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    @Autowired
    TodoService todoService;

    static ApplicationContext applicationContext;

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(TodoApplication.class);
        springApplication.setBannerMode(Mode.OFF);
        applicationContext = springApplication.run(args);

        TodoService serviceBean = applicationContext.getBean(TodoService.class);
        System.out.println(serviceBean.addTodo("service bean"));

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Main command Line runner Running");
        System.out.println(this.todoService.addTodo("A new todo"));

    }

}
