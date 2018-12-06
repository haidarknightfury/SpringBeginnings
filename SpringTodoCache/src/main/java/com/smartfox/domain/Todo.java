package com.smartfox.domain;

public class Todo {

    private String name;
    private String body;
    private Boolean cacheable;

    public Todo(String name, String body) {
        super();
        this.name = name;
        this.body = body;
        this.setCacheable(true);
    }

    public Todo(String name, String body, Boolean cacheable) {
        super();
        this.name = name;
        this.body = body;
        this.setCacheable(cacheable);
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

    public Boolean getCacheable() {
        return this.cacheable;
    }

    public void setCacheable(Boolean cacheable) {
        this.cacheable = cacheable;
    }

}
