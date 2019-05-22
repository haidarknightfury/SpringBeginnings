package com.smartfox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.model.User;
import com.smartfox.repository.UserRepository;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(com.smartfox.repository.UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/users")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<List<User>>(this.userRepository.findAll(), HttpStatus.OK);
    }
}
