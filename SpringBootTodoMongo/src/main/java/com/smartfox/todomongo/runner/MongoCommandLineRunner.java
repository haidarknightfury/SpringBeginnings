package com.smartfox.todomongo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.smartfox.todomongo.domain.Todo;
import com.smartfox.todomongo.domain.User;
import com.smartfox.todomongo.service.TodoServiceImpl;

@Component
public class MongoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private TodoServiceImpl todoService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public void run(String... arg0) throws Exception {

        System.out.println("hello mongo");
        User user = this.todoService.saveUser(new User("haidar", "hdargaye@mail.com"));
        Todo todo = this.todoService.saveTodo(new Todo("title", "body", user));
        System.out.println(todo);
        System.out.println(this.todoService.getAllTodos());

        // Using mongo template
        this.mongoTemplate.insert(new User("anotheruser", "anothereamil@mail.com"));
        System.out.println(this.mongoTemplate.getCollectionName(User.class));
        System.out.println(this.mongoTemplate.findAll(User.class));

        System.out.println(this.mongoOperation.getCollection("todo").count());
        System.out.println(this.mongoOperation.findById("haidar", User.class));

        List<Todo> todos = this.mongoOperation.find(Query.query(Criteria.where("title").is("title").and("body").is("body")), Todo.class);
        System.out.println(todos);

        // Removing an object
        this.mongoOperation.remove(this.mongoOperation.findById("haidar", User.class));

    }
}
