package com.smartfox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.smartfox.service.TodoService;

@Configuration
@ComponentScan(basePackages = { "com.smartfox" })
public class AppConfig {

    @Bean
    public HttpInvokerProxyFactoryBean todoService() {
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/todohttpinvoker/todo.service");
        proxy.setServiceInterface(TodoService.class);
        return proxy;
    }

}
