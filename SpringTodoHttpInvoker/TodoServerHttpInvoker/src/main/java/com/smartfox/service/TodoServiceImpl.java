package com.smartfox.service;

import com.smartfox.domain.Todo;

public class TodoServiceImpl implements TodoService {

    public void print(Todo todo) {
        System.out.println(todo.toString());
    }

}
