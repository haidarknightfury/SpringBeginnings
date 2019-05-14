package com.smartfox.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfigs {

    @Bean
    public FilterRegistrationBean createFilterBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CreateFilter());
        filterRegistrationBean.addUrlPatterns("/create/*");
        return filterRegistrationBean;
    }
}
