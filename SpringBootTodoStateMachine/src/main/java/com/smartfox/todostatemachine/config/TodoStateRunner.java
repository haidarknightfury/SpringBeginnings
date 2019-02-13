package com.smartfox.todostatemachine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import com.smartfox.todostatemachine.listener.TodoStateMachineListener;
import com.smartfox.todostatemachine.state.Events;
import com.smartfox.todostatemachine.state.States;

/**
 * Just a runner to start the statemachine and trigger events
 * @author hdargaye
 *
 */
@Component
public class TodoStateRunner implements CommandLineRunner {

    @Autowired
    StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        this.stateMachine.start();
        // Add Listener to state machine
        this.stateMachine.addStateListener(new TodoStateMachineListener());
        this.stateMachine.sendEvent(Events.INITIALISE);
        this.stateMachine.sendEvent(Events.SAVE);
    }

}
