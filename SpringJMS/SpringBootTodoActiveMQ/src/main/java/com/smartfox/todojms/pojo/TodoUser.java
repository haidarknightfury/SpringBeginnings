package com.smartfox.todojms.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoUser implements Serializable {

	private static final long serialVersionUID = -2950659140359634065L;

	private  String todoUserId;

	private Todo todo;
	private User user;
	
	public TodoUser() {}

	@JsonCreator
	public TodoUser(@JsonProperty("todoUserID")String todoUserId, @JsonProperty("todo")Todo todo, @JsonProperty("user")User user) {
		this.todoUserId = todoUserId;
		this.todo = todo;
		this.user = user;
	}

	public String getTodoUserId() {
		return todoUserId;
	}

	public Todo getTodo() {
		return todo;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "TodoUser [todoUserId=" + todoUserId + ", todo=" + todo + ", user=" + user + "]";
	}
	
	
}
