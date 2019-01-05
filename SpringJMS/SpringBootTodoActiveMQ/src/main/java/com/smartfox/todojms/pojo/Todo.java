package com.smartfox.todojms.pojo;

import java.io.Serializable;

public class Todo implements Serializable {

	public Todo() {}

	private static final long serialVersionUID = 1L;
	private String todoID;
	private String title;

	public Todo(String todoID, String title) {
		super();
		this.todoID = todoID;
		this.title = title;
	}

	public String getTodoID() {
		return todoID;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Todo [todoID=" + todoID + ", title=" + title + "]";
	}

}
