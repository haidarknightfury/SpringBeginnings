package com.smartfox.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String name;
    private String otherNames;

    public UserDTO(String username, String name, String otherNames) {
        super();
        this.username = username;
        this.name = name;
        this.otherNames = otherNames;
    }

    public String getName() {
        return this.name;
    }

    public String getOtherNames() {
        return this.otherNames;
    }

    public String getUsername() {
        return this.username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [username=" + this.username + ", name=" + this.name + ", otherNames=" + this.otherNames + "]";
    }

}
