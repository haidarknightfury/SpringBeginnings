package com.smartfox.todomongo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {

    private Integer todoid;

    private String title;

    private String body;

    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo() {
        super();
    }

    public Todo(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
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

    public Integer getTodoid() {
        return this.todoid;
    }

    public void setTodoid(Integer todoid) {
        this.todoid = todoid;
    }

    @Override
    public String toString() {
        return "Todo [todoid=" + this.todoid + ", title=" + this.title + ", body=" + this.body + ", user=" + this.user + "]";
    }

}
