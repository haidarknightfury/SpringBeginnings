package com.smartfox.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.smartfox.config.security.SmartfoxUserDetail;
import com.smartfox.dto.TodoDTO;
import com.smartfox.exceptions.TodoNotFoundException;
import com.smartfox.model.Todo;
import com.smartfox.model.User;
import com.smartfox.repository.UserRepository;
import com.smartfox.service.TodoServiceImpl;

@RestController
public class TodoController {

    private TodoServiceImpl todoService;
    private UserRepository userRepository;

    @Autowired
    public TodoController(TodoServiceImpl todoService, UserRepository userRepository) {
        this.todoService = todoService;
        this.userRepository = userRepository;
    }

    @ModelAttribute
    public User addModelBeforeTodoCalls(HttpServletRequest request, Authentication authentication) {
        System.out.println("Before Calling Method : " + request.getMethod().toString());
        if (authentication == null || authentication.getPrincipal() == null) {
            return null;
        }
        return ((SmartfoxUserDetail) authentication.getPrincipal()).getUser();
    }

    // http://localhost:8080/TodoWeb-0.0.1-SNAPSHOT/get/1
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Todo> getTodo(@PathVariable String id) throws TodoNotFoundException {
        Todo fTodo = this.todoService.getTodos().stream().filter(todo -> todo.getTodoId().equals(Long.valueOf(id))).findFirst().orElseThrow(() -> new TodoNotFoundException());
        return new ResponseEntity<Todo>(fTodo, HttpStatus.OK);
    }

    // http://localhost:8080/TodoWeb-0.0.1-SNAPSHOT/create
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Todo> saveTodo(@RequestBody TodoDTO todoDto, UriComponentsBuilder ucb) {
        Todo todo = new Todo(todoDto.getLabel(), todoDto.getCreatedDate(), todoDto.getBody(), todoDto.getFlag());
        this.todoService.addTodo(todo);
        HttpHeaders headers = new HttpHeaders();
        URI locationUrl = ucb.path("/todos/").path(String.valueOf(todo.getTodoId())).build().toUri();
        headers.setLocation(locationUrl);

        ResponseEntity<Todo> responseEntity = new ResponseEntity<>(todo, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> test(@ModelAttribute("user") User user) {
        System.out.println("User : " + user + " is getting all the todos");
        this.todoService.runQuery();
        return new ResponseEntity<>(this.todoService.getTodos(), HttpStatus.OK);
    }

}
