package com.smartfox.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages = "com.smartfox") // Scans all Repository/Service/Controller
@Configuration
public class TodoConfig {

}
