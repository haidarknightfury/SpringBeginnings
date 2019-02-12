package com.smartfox.config;

import com.smartfox.entity.Todo;
import com.smartfox.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.tools.jar.CommandLine;

/**
 * Created by hdargaye on 12/02/2019.
 */
@Component
public class TodoRunner implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("Hello", "Panda"));
    }
}
