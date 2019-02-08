package com.smartfox.todostatemachine.domain;

public class Todo {
    private String description;
    private String name;

    public Todo(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Todo [name=" + this.name + ", description=" + this.description + "]";
    }

}
