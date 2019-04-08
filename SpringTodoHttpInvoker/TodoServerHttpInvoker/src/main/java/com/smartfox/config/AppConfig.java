package com.smartfox.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.smartfox.service.TodoService;
import com.smartfox.service.TodoServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.smartfox")
public class AppConfig {

    /**
     * Dispatcher must be able to handle *.service
     */
    @Bean
    public HandlerMapping httpInvokerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/todo.service", "httpInvokerServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }

    /**
     * Work as a controller - MVC Controller - receives request from the client through DispatcherServlet and translate those requests
     * to method calls on the service implementation pojo
     */
    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(TodoService todoService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(todoService);
        exporter.setServiceInterface(TodoService.class);
        return exporter;
    }

    @Bean
    TodoService todoService() {
        return new TodoServiceImpl();
    }
}
