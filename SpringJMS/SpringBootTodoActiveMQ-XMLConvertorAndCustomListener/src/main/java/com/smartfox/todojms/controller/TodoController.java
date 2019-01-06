package com.smartfox.todojms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.todojms.pojo.Todo;
import com.smartfox.todojms.pojo.TodoUser;
import com.smartfox.todojms.pojo.User;
import com.smartfox.todojms.service.ProcessedTodoUserService;
import com.smartfox.todojms.service.TodoUserService;

@RestController
@RequestMapping(value = "/")
public class TodoController {

	@Autowired
	private TodoUserService todoUserService;
	
	@Autowired
	private ProcessedTodoUserService processedTodoUserService;
	
	@RequestMapping(value = "", method = { RequestMethod.GET }, produces = { "application/json" })
	public Todo getTodo() {
		Todo todo = new Todo("ID", "TITLE");
		User user = new User("haidar", "H00");
		TodoUser todoUser = new TodoUser("T00H00", todo, user);
		todoUserService.send(todoUser);
		processedTodoUserService.processTodoUser(todoUser);
		return todo;
	}
}
