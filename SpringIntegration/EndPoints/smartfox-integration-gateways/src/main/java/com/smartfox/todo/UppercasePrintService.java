package com.smartfox.todo;

import com.smartfox.todo.Person;

public class UppercasePrintService {
	public String execute(Person person) {
		return (person.getFname() + " " + person.getSname()).toUpperCase();
	}
}
