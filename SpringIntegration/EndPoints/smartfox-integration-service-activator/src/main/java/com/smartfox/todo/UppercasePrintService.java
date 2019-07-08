package com.smartfox.todo;

import com.smartfox.todo.Person;

public class UppercasePrintService {
	
	public String execute(Person person) {
		return (person.getFname() + " " + person.getSname()).toUpperCase();
	}


//	public Message<String> execute(Message<Person> person) {
//		person.getHeaders().entrySet().forEach(entry -> {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		});
//		System.out.println(((MessageChannel) person.getHeaders().get("replyChannel")).toString());
//		System.out.println("EXECUTING IN UPPERCASE PRINT SERVICE" + person.getPayload());
//
//		Message<String> msg = MessageBuilder
//				.withPayload((person.getPayload().getFname() + " " + person.getPayload().getSname()).toUpperCase())
//				.copyHeaders(person.getHeaders()).setReplyChannelName("outputChannel").build();
//
//		System.out.println(msg);
//		return msg;
//	}
}
