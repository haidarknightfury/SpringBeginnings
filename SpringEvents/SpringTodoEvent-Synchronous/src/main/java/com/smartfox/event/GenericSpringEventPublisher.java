package com.smartfox.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class GenericSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void sendGenericEvent() {
        this.applicationEventPublisher.publishEvent(new GenericEvent<String>("hello generics", true));
    }
}
