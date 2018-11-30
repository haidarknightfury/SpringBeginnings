package com.smartfox.todomongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.todomongo.domain.Todo;
import com.smartfox.todomongo.domain.User;
import com.smartfox.todomongo.repository.TodoRepository;
import com.smartfox.todomongo.repository.UserRepository;

@Service
public class TodoServiceImpl {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo saveTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return this.todoRepository.findAll();
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

}
