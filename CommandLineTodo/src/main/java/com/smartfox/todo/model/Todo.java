package com.smartfox.todo.model;

import java.time.LocalDate;

public class Todo {

    private String name;

    private LocalDate todoBefore;

    private String details;

    public Todo(String name, LocalDate date, String details) {
        this.name = name;
        this.todoBefore = date;
        this.details = details;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTodoBefore() {
        return this.todoBefore;
    }

    public void setTodoBefore(LocalDate todoBefore) {
        this.todoBefore = todoBefore;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Todo [name=" + this.name + ", todoBefore=" + this.todoBefore + ", details=" + this.details + "]";
    }

}
