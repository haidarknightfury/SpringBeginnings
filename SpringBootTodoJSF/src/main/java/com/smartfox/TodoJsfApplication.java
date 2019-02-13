package com.smartfox;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

@EnableAutoConfiguration
@ComponentScan({"com.smartfox"})
public class TodoJsfApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TodoJsfApplication.class, args);
	}


}

