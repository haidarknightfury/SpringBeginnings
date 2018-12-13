package com.smartfox.model;

import java.io.Serializable;

public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String body;

    public Todo(String name, String body) {
        super();
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Todo [name=" + this.name + ", body=" + this.body + "]";
    }

}
