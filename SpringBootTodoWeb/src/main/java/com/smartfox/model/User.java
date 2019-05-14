package com.smartfox.model;

public class User {
    private String name;
    private String username;

    public User(String name, String username) {
        super();
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [name=" + this.name + ", username=" + this.username + "]";
    }

}
