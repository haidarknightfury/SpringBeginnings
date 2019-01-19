package com.smartfox.todobatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableBatchProcessing
public class TodobatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodobatchApplication.class, args);
	}

}
