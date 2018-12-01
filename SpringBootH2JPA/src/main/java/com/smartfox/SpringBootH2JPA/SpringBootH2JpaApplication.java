package com.smartfox.SpringBootH2JPA;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smartfox.SpringBootH2JPA.model.Todo;
import com.smartfox.SpringBootH2JPA.repository.TodoRepository;
import com.smartfox.SpringBootH2JPA.service.TodoService;

@SpringBootApplication
public class SpringBootH2JpaApplication implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;
    
    @Autowired
    TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootH2JpaApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("Hello world");
        this.todoRepository.save(new Todo("first", LocalDateTime.now(), "body", "flag"));
        this.todoRepository.findAll().forEach(System.out::println);
        
        System.out.println("--------Using Query DSL---------");
        this.todoService.findByTitleAndBody("first", "body").forEach(System.out::println);
    }
}
