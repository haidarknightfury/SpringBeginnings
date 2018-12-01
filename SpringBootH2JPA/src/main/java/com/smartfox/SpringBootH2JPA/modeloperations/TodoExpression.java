package com.smartfox.SpringBootH2JPA.modeloperations;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.smartfox.SpringBootH2JPA.model.QTodo;

public class TodoExpression {
	
	public static BooleanExpression matchByTitle(String title) {
		return QTodo.todo.label.eq(title);
	}
	
	public static BooleanExpression matchByBody(String body) {
		return QTodo.todo.body.equalsIgnoreCase(body);
	}
}
