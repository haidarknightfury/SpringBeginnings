package com.smartfox.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.smartfox") // Scans all Repository/Service/Controller
@Configuration
public class TodoConfig {

}
