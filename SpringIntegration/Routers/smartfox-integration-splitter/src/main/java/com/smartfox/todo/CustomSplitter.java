package com.smartfox.todo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

/**
 * @author Haidar
 *
 */

// Can also not use AbstractMessageSplitter
// But use a public method for the split method
public class CustomSplitter extends AbstractMessageSplitter{

	@Override
	protected Object splitMessage(Message<?> message) {
		return new ArrayList<String>(Arrays.asList(((String) message.getPayload()).split(" ")));
	}

}
