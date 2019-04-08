package com.smartfox.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.smartfox.model.Todo;
import com.smartfox.service.TodoServiceImpl;

/*
 * Extends SpringBeanAutowiringSupport for autowiring in webservice
 */
@Component
@WebService(serviceName = "TodoWebService")
public class TodoWebServiceEndpoint extends SpringBeanAutowiringSupport {

    @Autowired
    public TodoServiceImpl todoServiceImpl;

    @WebMethod
    public void addTodo(Todo todo) {
        this.todoServiceImpl.addTodo(todo);
    }

    @WebMethod
    public void deleteTodo(Todo todo) {
        this.todoServiceImpl.deleteTodo(todo);
    }

}
