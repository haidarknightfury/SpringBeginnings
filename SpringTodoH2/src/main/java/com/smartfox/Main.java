package com.smartfox;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smartfox.config.TodoConfig;
import com.smartfox.model.Todo;
import com.smartfox.service.TodoServiceImpl;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TodoConfig.class);
        TodoServiceImpl todoService = context.getBean(TodoServiceImpl.class);

        todoService.addTodo(new Todo("hi", LocalDateTime.now(), "body", "done"));
        System.out.println("DISPLAYING ALL TODOS : " + todoService.buildListTodos());

        System.out.println(todoService.runQuery());
        System.out.println("List of todos" + todoService.runQueryMoreResults());

        context.close();

    }

}
