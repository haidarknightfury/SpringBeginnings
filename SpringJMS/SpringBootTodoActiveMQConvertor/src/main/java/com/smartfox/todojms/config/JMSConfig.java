package com.smartfox.todojms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.smartfox.todojms.listener.ProcessedTodoReceiver;
import com.smartfox.todojms.pojo.Todo;
import com.smartfox.todojms.pojo.TodoUser;
import com.smartfox.todojms.pojo.User;

@Configuration
@EnableJms
public class JMSConfig implements JmsListenerConfigurer {
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");// 3rd parameter -> broker
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setMessageConverter(xmlMarshallingMessageConvertor());
		return jmsTemplate;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory());
		containerFactory.setMessageConverter(xmlMarshallingMessageConvertor());
		containerFactory.setConcurrency("1-1");
		return containerFactory;
	}
	
	@Bean
	public MessageConverter xmlMarshallingMessageConvertor() {
		MarshallingMessageConverter marshallingMessageConverter = new  MarshallingMessageConverter(xmlMarshaller()); // use both marshalling and unmarshalling
		marshallingMessageConverter.setTargetType(MessageType.TEXT); // No need to set type
		return marshallingMessageConverter;
	}
	
	@Bean// No extra mapping files - x stream ignores the annotations such as json properties..
	public XStreamMarshaller xmlMarshaller() {
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setSupportedClasses(Todo.class, TodoUser.class, User.class);
		return marshaller;
	}
	
	@Bean
	public ProcessedTodoReceiver jmsMessageListener() {
		ProcessedTodoReceiver listener = new ProcessedTodoReceiver();
		return listener;
	}

	@Override
	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
		endpoint.setMessageListener(jmsMessageListener()); // Register the listener
		endpoint.setDestination("todo-processed-queue"); // Must implement JMSConfigurerListener - custom listener
		endpoint.setId("todo-processed-queue");
		endpoint.setSubscription("todo-processed-subscription");
		endpoint.setConcurrency("1");
		registrar.setContainerFactory(defaultJmsListenerContainerFactory());
		registrar.registerEndpoint(endpoint, defaultJmsListenerContainerFactory());
	}

}
