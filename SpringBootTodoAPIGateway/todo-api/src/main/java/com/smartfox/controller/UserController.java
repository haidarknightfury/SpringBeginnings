package com.smartfox.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.dto.UserDTO;
import com.smartfox.mapper.UserMapper;
import com.smartfox.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<List<UserDTO>>(this.userService.findAll().stream().map(UserMapper::convert).collect(Collectors.toList()), HttpStatus.OK);
    }

}
