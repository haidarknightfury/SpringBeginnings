package com.smartfox.domain;

/**
 * Todo Class
 * 
 * @author Haidar
 *
 */
public class Todo {

	private String title;
	private String description;

	public Todo() {}

	public Todo(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Todo [title=" + title + ", description=" + description + "]";
	}

}
