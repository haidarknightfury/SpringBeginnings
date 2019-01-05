package com.smartfox.todojms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JMSConfig {

	/**
	 * Creating a container factory - uses the MOM behind - the queue is set up also
	 * 
	 */
	@Bean
	public JmsListenerContainerFactory warehouseFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		configurer.configure(containerFactory, connectionFactory);
		return containerFactory;
	}
}
