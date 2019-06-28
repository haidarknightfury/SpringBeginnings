package com.smartfox.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.messaging.Message;

/**
 * @author Haidar
 *
 */
public class CustomSplitter {

	public List<String> splitMessage(Message<String> message) {
		return new ArrayList<String>(Arrays.asList(((String) message.getPayload()).split(" ")));
	}

}
