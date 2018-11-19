package com.smartfox.todo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
// get useful methods to get the arguments
// implementing application runner - automatically run task
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (String str : args.getSourceArgs()) {
            sb.append(str);
        }
        logger.info("Your application started with option names : {}", sb.toString());
    }

}
