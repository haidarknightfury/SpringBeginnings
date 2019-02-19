package com.smartfox.event;

import org.springframework.context.ApplicationEvent;

/**
 * Simple event class - placeholder to store event data
 * @author hdargaye
 *
 */
public class TodoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private String message;

    public TodoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
