package com.smartfox.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("integration-context.xml")
@Configuration
public class SmartfoxIntegrationApplication implements ApplicationRunner {


	@Autowired
	private PrinterGateway printerGateway;

	public static void main(String[] args) {
		SpringApplication.run(SmartfoxIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Person person = new Person("haidar", "dargaye");
		Message<?> message = MessageBuilder.withPayload(person).setHeader("privateKey", "1234").build();
		printerGateway.print(message);
	}

}
