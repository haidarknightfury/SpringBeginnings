package com.smartfox.todomongo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.smartfox.todomongo.domain.Todo;
import com.smartfox.todomongo.service.TodoServiceImpl;

@Component
public class MongoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private TodoServiceImpl todoService;

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("hello mongo");
        Todo todo = this.todoService.saveTodo(new Todo("title", "body"));
        System.out.println(todo);
    }
}
