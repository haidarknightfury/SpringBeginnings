package com.smartfox.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TodoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String label;
    private LocalDateTime createdDate;
    private String body;
    private String flag;

    public TodoDTO() {
    }

    public TodoDTO(String label, LocalDateTime createdDate, String body, String flag) {
        super();
        this.label = label;
        this.createdDate = createdDate;
        this.body = body;
        this.flag = flag;
    }

    public String getBody() {
        return this.body;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getLabel() {
        return this.label;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "TodoDTO [label=" + this.label + ", createdDate=" + this.createdDate + ", body=" + this.body + ", flag=" + this.flag + "]";
    }

}
