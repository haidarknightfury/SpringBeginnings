package com.smartfox.todo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("integration-context.xml")
@Configuration
public class SmartfoxIntegrationApplication implements ApplicationRunner {

	@Autowired
	@Qualifier("inputChannel")
	private DirectChannel directChannel;
	
	@Autowired
	@Qualifier("outputChannel")
	private DirectChannel outputChannel;
	
	public static void main(String[] args) {
		SpringApplication.run(SmartfoxIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		outputChannel.subscribe(new MessageHandler() {
			
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				System.out.println("output channel received "+ message.getPayload());
				
			}
		});
			
		basicMessages();
		//registerHandler();
		Message<String> msg = MessageBuilder.withPayload("DIRECT CHANNEL world builder")
				   .setHeader("DIRECT CHANNEL", "DIRECT CHANNEL").build();
		directChannel.send(msg);
		
	}

	private void basicMessages() {
		System.out.println("Hello World");
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("key", "value");
		MessageHeaders messageHeaders = new MessageHeaders(headerMap);
		
		Message<String> message = new GenericMessage<String>("Hello World",messageHeaders);
		
		Message<String> anotherMessage = MessageBuilder.withPayload("hello world builder")
													   .setHeader("newHeader", "value").build();
		
		PrintService printService = new PrintService();
		printService.print(message);
		printService.print(anotherMessage);
	}
	
	
	public void registerHandler() {
		
		directChannel.subscribe(new MessageHandler() {
			
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				new PrintService().print((Message<String>) message);
			}
		});
		
	}

}
