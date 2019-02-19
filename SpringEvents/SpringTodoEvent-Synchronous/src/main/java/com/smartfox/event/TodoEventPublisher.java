package com.smartfox.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Can Also implement ApplicationEventPublisherAware
 * @author hdargaye
 *
 */
@Component
public class TodoEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishTodoEvent(final String message) {
        System.out.println("Publishing custom event");
        TodoEvent event = new TodoEvent(this, message);
        this.applicationEventPublisher.publishEvent(event);
    }
}
