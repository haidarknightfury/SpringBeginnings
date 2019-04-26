package com.smartfox.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.smartfox.exceptions.ErrorDto;
import com.smartfox.exceptions.TodoNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f
    @ExceptionHandler({ TodoNotFoundException.class, IllegalArgumentException.class })
    public ResponseEntity<ErrorDto> todoNotFound(TodoNotFoundException e) {
        return new ResponseEntity<ErrorDto>(new ErrorDto("not found"), HttpStatus.NOT_FOUND);
    }

}
