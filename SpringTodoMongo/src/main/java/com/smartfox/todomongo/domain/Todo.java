package com.smartfox.todomongo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {

    private Integer todoid;

    private String title;

    private String body;

    public Todo() {

    }

    public Todo(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Todo [todo_id=" + this.todoid + ", title=" + this.title + ", body=" + this.body + "]";
    }

    public Integer getTodoid() {
        return this.todoid;
    }

    public void setTodoid(Integer todoid) {
        this.todoid = todoid;
    }

}
