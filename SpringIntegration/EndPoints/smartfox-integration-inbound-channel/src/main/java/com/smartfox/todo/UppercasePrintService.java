package com.smartfox.todo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.smartfox.todo.Person;

public class UppercasePrintService {
	public String execute(Person person) throws InterruptedException {
		TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		return (person.getFname() + " " + person.getSname()).toUpperCase();
	}
}
