package com.smartfox.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Security Config class - must extend WebSecurityConfigurerAdapter
 * @author hdargaye
 *
 */
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SmartfoxUserDetailService smartfoxUserDetailService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.smartfoxUserDetailService); // Service must implement UserDetailService - automatically load the User by the username
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authenticate all the other requests and use httpBasic for authentication
        http.csrf().disable().authorizeRequests().antMatchers("/index", "/css", "/js/*").permitAll().anyRequest().authenticated().and().httpBasic();
    }

}
