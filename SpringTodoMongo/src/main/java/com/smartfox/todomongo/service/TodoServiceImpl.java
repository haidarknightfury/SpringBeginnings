package com.smartfox.todomongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.todomongo.domain.Todo;
import com.smartfox.todomongo.repository.TodoRepository;

@Service
public class TodoServiceImpl {

    @Autowired
    private TodoRepository todoRepository;

    public Todo saveTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return this.todoRepository.findAll();
    }
}
