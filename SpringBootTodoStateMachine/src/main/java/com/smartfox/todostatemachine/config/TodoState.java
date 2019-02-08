package com.smartfox.todostatemachine.config;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class TodoState {

    @OnTransition(source = "INITIALIZE", target = "END")
    void initializeState() {
        System.out.println("STARTING INITIAL STATE");
    }
}
