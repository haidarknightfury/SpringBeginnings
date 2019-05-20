package com.smartfox.dto.builder;

import java.time.LocalDateTime;

import com.smartfox.dto.TodoDTO;

public class TodoDTOBuilder {

    private String label;
    private LocalDateTime createdDate;
    private String body;
    private String flag;

    public TodoDTOBuilder setLabel(String label) {
        this.label = label;
        return this;
    }

    public TodoDTOBuilder setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TodoDTOBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public TodoDTOBuilder setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public TodoDTO build() {
        return new TodoDTO(this.label, this.createdDate, this.body, this.flag);
    }

}
