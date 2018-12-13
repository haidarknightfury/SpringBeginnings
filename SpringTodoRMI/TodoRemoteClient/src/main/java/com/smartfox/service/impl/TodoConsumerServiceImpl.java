package com.smartfox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.model.Todo;
import com.smartfox.service.TodoService;

@Service
public class TodoConsumerServiceImpl {

    @Autowired
    TodoService todoService;

    public Todo find() {
        Todo todo = this.todoService.find("hello");
        System.out.println(todo);
        return todo;
    }
}
