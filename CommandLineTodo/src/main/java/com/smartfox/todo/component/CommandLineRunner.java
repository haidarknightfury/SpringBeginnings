package com.smartfox.todo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Running the command line runner {}", args);
    }

}
