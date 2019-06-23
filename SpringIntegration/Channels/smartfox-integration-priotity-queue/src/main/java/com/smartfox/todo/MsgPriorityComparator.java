package com.smartfox.todo;

import java.util.Comparator;

import org.springframework.messaging.Message;

public class MsgPriorityComparator implements Comparator<Message<String>>{

	@Override
	public int compare(Message<String> o1, Message<String> o2) {
		int h1 = (int) o1.getHeaders().get("priority");
		int h2 = (int) o2.getHeaders().get("priority");
		return h2 - h1;
	}

}
