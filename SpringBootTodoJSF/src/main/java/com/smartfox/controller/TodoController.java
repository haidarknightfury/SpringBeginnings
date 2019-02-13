package com.smartfox.controller;

import com.smartfox.entity.Todo;
import com.smartfox.repository.TodoRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by hdargaye on 13/02/2019.
 */

@Scope(value = "session") //a single instance of this class will exist per user
@Component(value = "todoController")
@ELBeanName(value = "todoController") //an annotation provided by Rewrite that configures the name of the bean on its scope
@Join(path = "/todo", to = "todo/todo-form.jsf") //provided by Rewrite—configures the /todo Url to respond with the contents of todo-form.xhtml
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    private Todo todo = new Todo();

    public void save() throws IOException {
        this.todoRepository.save(todo);
        todo = new Todo();
        FacesContext.getCurrentInstance().getExternalContext().redirect("");
    }

    public Todo getTodo(){
        return todo;
    }

}
