package com.smartfox.todojms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class TodojmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodojmsApplication.class, args);
	}
}
