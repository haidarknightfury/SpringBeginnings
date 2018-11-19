package com.smartfox.todo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.smartfox.todo.builder.TodoBuilder;
import com.smartfox.todo.model.Todo;

@Service
public class TodoService {

    private TodoBuilder todoBuilder;

    // Automatically injected as it is only parameter in constructor
    public TodoService(TodoBuilder builder) {
        this.todoBuilder = builder;
    }

    // default is world
    @Value("${name:World}")
    private String name;

    public void hello() {
        Todo todo = this.todoBuilder.name(this.name).build();
        System.out.println(todo);
    }

    public String addTodo(String text) {
        Todo todo = this.todoBuilder.name(text).build();
        return todo.toString();
    }

}
