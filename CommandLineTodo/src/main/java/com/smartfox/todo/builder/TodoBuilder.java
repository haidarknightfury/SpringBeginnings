package com.smartfox.todo.builder;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.smartfox.todo.model.Todo;

@Service
public class TodoBuilder {

    private String name;
    private LocalDate beforeDate;
    private String details;

    public TodoBuilder name(String name) {
        this.name = name;
        return this;
    }

    public TodoBuilder details(String details) {
        this.details = details;
        return this;
    }

    public TodoBuilder beforeDate(String details) {
        this.details = details;
        return this;
    }

    public Todo build() {
        return new Todo(this.name, this.beforeDate, this.details);
    }

}
