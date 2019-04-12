package com.smartfox.exceptions;

public class TodoNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public TodoNotFoundException() {
        super();
    }

    public TodoNotFoundException(String message) {
        super(message);
    }

    public TodoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TodoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TodoNotFoundException(Throwable cause) {
        super(cause);
    }

}
