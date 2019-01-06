package com.smartfox.todojms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.smartfox.todojms.pojo.TodoUser;
import com.smartfox.todojms.pojo.User;

@Component
public class TodoReceiver {
	
	/**
	 * Only one jms listener for a queue  - use default
	 */
	@JmsListener(destination="todo-queue") // connection factory not specified - use default JMS Factory configured in config
	public void receiveMessage(String message) {
		System.out.println("Todo received is "+ message);
	}
	
	@JmsListener(destination = "user-queue")
	public JmsResponse<Message<User>> receiveUser(@Payload User user, @Header(name = "userstate") String userstate, @Header(name="userid") String userid){
		System.out.println("OBTAINED : "+ user);
		// For dynammic sending to queue - returning a JMSResponse - no need for @SendTo
		return JmsResponse.forQueue(build(user,"ADDED" , userid), "user-added-queue");
	}
	
	
	@JmsListener(destination = "todo-user-queue") // 1. automatically picks up transactional management - no need to specify @transactional
	@SendTo("todo-user-processed-state-queue") // 2. Added to send the returned value to a queue - But need to be wrapped in message<> to contain header elements
	public Message<TodoUser> receiveTodoUserMessage(@Payload TodoUser todoUser, @Header(name = "todostate") String todoState, 
			@Header(name="todoid") String todoId, MessageHeaders messageHeaders) {
		System.out.println(todoUser);
		System.out.println("TODO STATE: "+ todoState);
		System.out.println("TODO ID : "+ todoId );
		System.out.println(messageHeaders.toString());
		return build(todoUser, "PROCESSED", todoId);
	}
	
	/**
	 * Build a message object
	 */
	private <T> Message<T> build(T obj, String todoState,String todoId){
		return MessageBuilder.withPayload(obj)
							 .setHeader("todostate", todoState)
							 .setHeader("todoid", todoId)
							 .build();
	}
	
	/**
	 * Build Message with user
	 */
	private Message<User> build(User user, String userstate, String userId){
		return MessageBuilder.withPayload(user)
							 .setHeader("userstate", userstate)
							 .setHeader("userid", userId)
							 .build();
	}

}
