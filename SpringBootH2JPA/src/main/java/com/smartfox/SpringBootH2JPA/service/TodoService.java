package com.smartfox.SpringBootH2JPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.SpringBootH2JPA.model.Todo;
import com.smartfox.SpringBootH2JPA.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }

}
