package com.smartfox.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.smartfox.domain.Todo;

@Component
public class TodoService {

    List<Todo> todos = new ArrayList<>();

    // Keys can be based on anything, if none specified then it will be the parameters passed

    @CachePut(value = "todo-cache", key = "#result.name")
    public Todo saveTodo(String name, String body) {
        Todo todo = new Todo(name, body);
        this.todos.add(todo);
        return todo;
    }

    @CachePut(value = "todo-cache", key = "#result.name", unless = "#result.cacheable==false")
    public Todo saveTodoUnless(String name, String body) {
        Todo todo = new Todo(name, body, false);
        this.todos.add(todo);
        return todo;
    }

    @CachePut(value = "todo-cache", key = "#result.name", condition = "#result.name.length() > 3")
    public Todo saveTodoCondition(String name, String body) {
        Todo todo = new Todo(name, body, false);
        this.todos.add(todo);
        return todo;
    }

    @Cacheable("todo-cache")
    public Todo findOne(String name) {
        System.out.println("find one method invoked");
        return this.todos.stream().filter(todo -> todo.getName().equals(name)).findFirst().get();
    }

    @CacheEvict("todo-cache")
    public void removeFromCache(String name) {
        System.out.println("removing from cache " + name);
    }

}
