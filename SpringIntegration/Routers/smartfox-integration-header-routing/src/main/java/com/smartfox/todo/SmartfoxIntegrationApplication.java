package com.smartfox.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

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

//  Use printer gateway instead of using direct channel
//	@Autowired
//	@Qualifier("inputChannel")
//	private DirectChannel directChannel;

	@Autowired
	private PrinterGateway printerGateway;

	public static void main(String[] args) {
		SpringApplication.run(SmartfoxIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int x = 0; x < 5; x++) {
			Message<String> message = MessageBuilder.withPayload("String Header Router").setHeader("routeHeader", "string").build();
			System.out.println("Sending message : "+x);
			printerGateway.print(message);
		}
		
		for (int x = 0; x < 5; x++) {
			Message<?> message = MessageBuilder.withPayload(x).setHeader("routeHeader", "int").build();
			System.out.println("Sending message : "+x);
			printerGateway.print(message);
		}
	}

}
