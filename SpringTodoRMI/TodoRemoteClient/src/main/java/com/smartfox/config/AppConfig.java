package com.smartfox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.smartfox.service.TodoService;

@Configuration
@ComponentScan(basePackages = "com.smartfox")
public class AppConfig {

    @Bean
    public RmiProxyFactoryBean todoService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost/TodoService");
        rmiProxy.setServiceInterface(TodoService.class);
        return rmiProxy;
    }

}
