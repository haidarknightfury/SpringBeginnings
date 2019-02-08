package com.smartfox.todostatemachine.config;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.smartfox.todostatemachine.state.Events;
import com.smartfox.todostatemachine.state.States;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        //// @formatter:off
        states.withStates()
        .initial(States.INITIAL)
        .states(EnumSet.allOf(States.class));
        // @formatter:on
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {

        //// @formatter:off

        // 2. Configuration of transitions - Which event causes the transitions
        transitions
        .withExternal()
           .source(States.INITIAL).target(States.END)
           .event(Events.INITIALISE)
        .and()
        .withExternal()
            .source(States.END).target(States.INITIAL)
            .event(Events.SAVE);
        // @formatter:on

    }

}
