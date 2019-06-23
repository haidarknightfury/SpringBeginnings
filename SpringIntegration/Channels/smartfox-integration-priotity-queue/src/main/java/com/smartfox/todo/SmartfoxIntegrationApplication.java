package com.smartfox.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
	
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
		List<Future<Message<String>>> futures = new ArrayList<>();
		for (int x = 0; x < 10; x++) {
			Message<String> message = MessageBuilder.withPayload("Printing Message for "+x)
										.setHeader("MessageNumber", x)
										.setHeader("priority", x)
										//.setPriority(x)
										.build();
			System.out.println("Sending message : "+x);
			futures.add(this.printerGateway.print(message)); // Pass message to the queue
		}
		
		for(Future<Message<String>> future: futures) {
			System.out.println(future.get().getPayload());
		}	
	}

}
