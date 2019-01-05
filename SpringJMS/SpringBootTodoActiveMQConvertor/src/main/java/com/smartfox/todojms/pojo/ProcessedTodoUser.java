package com.smartfox.todojms.pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class ProcessedTodoUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private TodoUser todoUser;
	private LocalDate dateProcessed;

	public ProcessedTodoUser(TodoUser todoUser, LocalDate dateProcessed) {
		super();
		this.todoUser = todoUser;
		this.dateProcessed = dateProcessed;
	}

	public TodoUser getTodoUser() {
		return todoUser;
	}

	public void setTodoUser(TodoUser todoUser) {
		this.todoUser = todoUser;
	}

	public LocalDate getDateProcessed() {
		return dateProcessed;
	}

	public void setDateProcessed(LocalDate dateProcessed) {
		this.dateProcessed = dateProcessed;
	}

	@Override
	public String toString() {
		return "ProcessedTodoUser [todoUser=" + todoUser + ", dateProcessed=" + dateProcessed + "]";
	}

}
