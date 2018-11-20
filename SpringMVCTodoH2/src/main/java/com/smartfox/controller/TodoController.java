package com.smartfox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.dto.TodoDTO;
import com.smartfox.service.TodoServiceImpl;

@RestController
public class TodoController {

    private TodoServiceImpl todoService;

    @Autowired
    public TodoController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TodoDTO>> test() {
        this.todoService.runQuery();
        return new ResponseEntity<>(this.todoService.buildListTodos(), HttpStatus.OK);
    }
}
