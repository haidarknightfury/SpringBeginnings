package com.smartfox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.domain.Todo;

@Service
public class TodoServiceCaller {

    @Autowired
    public TodoService todoService;

    public void run() {
        this.todoService.print(new Todo("hey", "boy"));
    }
}
