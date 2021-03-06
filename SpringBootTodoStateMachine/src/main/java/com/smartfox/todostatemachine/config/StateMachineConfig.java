package com.smartfox.todostatemachine.config;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.smartfox.todostatemachine.service.TodoEndService;
import com.smartfox.todostatemachine.service.TodoInitializationService;
import com.smartfox.todostatemachine.state.Events;
import com.smartfox.todostatemachine.state.States;

/**
 * Main Configuration class to configure the different states and what triggers them
 * Extend EnumStateMachineConfigurerAdapter - Based on Enums - Can also use String
 * @author hdargaye
 *
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Autowired
    TodoEndService todoEndService;

    @Autowired
    TodoInitializationService todoInitializationService;

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        //// @formatter:off
        states.withStates()
        .initial(States.INITIAL, context -> System.out.println("INITIAL ACTION"))
        .states(EnumSet.allOf(States.class));
        // @formatter:on
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {

        //// @formatter:off

        // 2. Configuration of transitions - Which event causes the transitions
        transitions
        .withExternal()
           .source(States.INITIAL).target(States.END).action(this.todoInitializationService)
           .event(Events.INITIALISE)
        .and()
        .withExternal()
            .source(States.END).target(States.INITIAL).action(this.todoEndService)
            .event(Events.SAVE);
        // @formatter:on

    }

}
