package com.smartfox.todostatemachine.listener;

import java.util.LinkedList;
import java.util.List;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateContext.Stage;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;

import com.smartfox.todostatemachine.state.Events;
import com.smartfox.todostatemachine.state.States;

/**
 * Another way to configure a Listener - must extend StateMachineListenerAdapter
 * Then It must be registered in the configurer
 * @author hdargaye
 *
 */
public class TodoStateMachineListener extends StateMachineListenerAdapter<States, Events> {

    final LinkedList<String> messages = new LinkedList<>();

    public List<String> getMessages() {
        return this.messages;
    }

    public void resetMessages() {
        this.messages.clear();
    }

    @Override
    public void stateContext(StateContext<States, Events> stateContext) {
        if (stateContext.getStage() == Stage.STATE_ENTRY) {
            System.out.println("LISTENER TRIGERRED : " + stateContext.getTarget().getId());
        }
    }

}
