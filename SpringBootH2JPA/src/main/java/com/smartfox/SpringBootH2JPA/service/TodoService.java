package com.smartfox.SpringBootH2JPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfox.SpringBootH2JPA.model.Todo;
import com.smartfox.SpringBootH2JPA.modeloperations.TodoExpression;
import com.smartfox.SpringBootH2JPA.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }
    
    public List<Todo> findByTitleAndBody(String title, String body){
    	return (List<Todo>) this.todoRepository.findAll(TodoExpression.matchByTitle(title).and(TodoExpression.matchByBody(body)));
    }

}
