package com.smartfox.todostatemachine.config;

import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Events Listener - Way for listening to events
 * Specifying Source / Target or Events
 * @author hdargaye
 *
 */

@WithStateMachine
public class TodoState {

    @OnTransitionStart(source = "INITIAL")
    public void transitiontest() {
        System.out.println("Event start");
    }

    @OnTransitionEnd(source = "INITIAL")
    public void transitiontested() {
        System.out.println("Event end");
    }

    @OnTransitionStart(source = "END")
    public void transitiontestend() {
        System.out.println("Event start");
    }

}
