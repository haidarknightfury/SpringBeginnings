package com.smartfox.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GenericSpringEventListener {

    @EventListener(condition = "#event.success")
    public void handleSuccessful(GenericEvent<Object> event) {
        System.out.println("Generic event - Condition" + event.getWhat());
    }
}
