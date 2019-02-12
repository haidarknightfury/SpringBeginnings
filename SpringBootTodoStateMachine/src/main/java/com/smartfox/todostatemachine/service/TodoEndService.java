package com.smartfox.todostatemachine.service;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Service;

import com.smartfox.todostatemachine.state.Events;
import com.smartfox.todostatemachine.state.States;

@Service
public class TodoEndService implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> context) {
        System.out.println("END SERVICE");
    }

}
