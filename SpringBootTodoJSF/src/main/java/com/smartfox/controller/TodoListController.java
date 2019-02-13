package com.smartfox.controller;

import com.smartfox.entity.Todo;
import com.smartfox.repository.TodoRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hdargaye on 13/02/2019.
 */

@Scope(value = "session")
@Component(value = "todoList")
@ELBeanName(value = "todoList")
@Join(path = "/", to="todo/todo-list.jsf")
public class TodoListController {

    @Autowired
    private TodoRepository todoRepository;

    private List<Todo> todos;

    //annotations are needed to load the collection of products before rendering the interface
    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData(){
        todos = this.todoRepository.findAll();
    }

    public List<Todo> getTodos(){
        return todos;
    }
}
