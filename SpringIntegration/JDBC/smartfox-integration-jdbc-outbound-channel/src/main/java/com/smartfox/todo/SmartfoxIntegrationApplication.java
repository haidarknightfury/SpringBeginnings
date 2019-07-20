package com.smartfox.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("integration-context.xml")
@Configuration
public class SmartfoxIntegrationApplication implements ApplicationRunner {

	@Autowired
	private PersonGateway personGateway;
	
	public static void main(String[] args) {
		SpringApplication.run(SmartfoxIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Person person = new Person();
		person.setId(1);
		person.setFirstName("Haidar");
		person.setLastName("dargaye");
		personGateway.save(person);
	}

}
