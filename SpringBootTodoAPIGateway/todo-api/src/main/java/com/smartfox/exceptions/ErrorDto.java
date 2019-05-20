package com.smartfox.exceptions;

import java.io.Serializable;

public class ErrorDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message;

    public ErrorDto(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
