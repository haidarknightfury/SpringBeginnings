package com.smartfox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.smartfox.service.TodoService;

@Configuration
@ComponentScan(basePackages = "com.smartfox")
public class AppConfig {

    @Bean
    RmiServiceExporter rmiServiceExporter(TodoService todoService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(todoService);
        rmiServiceExporter.setServiceName("TodoService");
        rmiServiceExporter.setServiceInterface(TodoService.class);
        return rmiServiceExporter;
    }

}
