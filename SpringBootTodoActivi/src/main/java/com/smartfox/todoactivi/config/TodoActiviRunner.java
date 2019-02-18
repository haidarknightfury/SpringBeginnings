package com.smartfox.todoactivi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.smartfox.todoactivi.service.PersonService;

@Component
public class TodoActiviRunner implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        this.personService.createPersons();
    }

}
