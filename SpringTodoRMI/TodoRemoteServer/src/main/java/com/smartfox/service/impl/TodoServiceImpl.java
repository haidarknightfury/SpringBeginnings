package com.smartfox.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smartfox.model.Todo;
import com.smartfox.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

    private List<Todo> todos = new ArrayList<Todo>();

    public Todo create(String name, String body) {
        Todo todo = new Todo(name, body);
        this.todos.add(todo);
        return todo;
    }

    public Todo find(String name) {
        return this.todos.stream().filter(todo -> todo.getName().equals(name)).findAny().orElse(null);
    }

}
