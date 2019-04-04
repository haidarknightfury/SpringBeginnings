package com.smartfox.domain;

import java.io.Serializable;

public class Todo implements Serializable {

    String desc;
    String name;

    public Todo(String desc, String name) {
        super();
        this.desc = desc;
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Todo [desc=" + this.desc + ", name=" + this.name + "]";
    }

}
