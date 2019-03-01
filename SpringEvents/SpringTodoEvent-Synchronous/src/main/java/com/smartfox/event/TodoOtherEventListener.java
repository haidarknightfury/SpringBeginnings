package com.smartfox.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TodoOtherEventListener {

    @EventListener
    public void handle(TodoEvent event) {
        System.out.println("Received in other event listener" + event.getMessage());
    }
}
