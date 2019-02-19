package com.smartfox.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TodoEventListener implements ApplicationListener<TodoEvent> {

    @Override
    public void onApplicationEvent(TodoEvent event) {
        System.out.println("Received Event : " + event.getMessage());
    }

}
