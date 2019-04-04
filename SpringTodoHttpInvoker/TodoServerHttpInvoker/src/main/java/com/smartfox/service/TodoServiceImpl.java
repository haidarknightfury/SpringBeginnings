package com.smartfox.service;

import org.springframework.stereotype.Service;

import com.smartfox.domain.Todo;

@Service
public class TodoServiceImpl implements TodoService {

    public void print(Todo todo) {
        System.out.println(todo.toString());
    }

}
