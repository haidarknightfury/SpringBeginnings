package com.smartfox.todojms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJms
@EnableTransactionManagement
public class JMSConfig {
	
	
	// From application.yml
	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;
	
	@Value("${spring.activemq.user}")
	private String user;
	
	@Value("${spring.activemq.password}")
	private String password;
	

	@Bean
	public SingleConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(user,password, brokerUrl);
		SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory(factory);
		singleConnectionFactory.setReconnectOnException(true);
		singleConnectionFactory.setClientId("myclientid");
		return singleConnectionFactory;
	}
	
//	@Bean
//	public CachingConnectionFactory cachingConnectionFactory() {
//		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(factory);
//		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(user,password, brokerUrl);
//		cachingConnectionFactory.setClientId("todoFront");
//		cachingConnectionFactory.setSessionCacheSize(100);// default 1
//		return cachingConnectionFactory;
//	}
	
	// Since application.yml already specifies connection factory
	// No need to declare a connectionfactory bean
	// Unless using variation of connection factory i.e SingleConnectionFactory or CachingConnectionFactory
	// More Moms -> More connection factory and jms templates
	
	@Bean
	@Autowired
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setMessageConverter(jacksonJMSMesageConvertor());
		
		jmsTemplate.setDeliveryPersistent(true);
		jmsTemplate.setSessionTransacted(true);// Enforce use of transaction manager
		
		return jmsTemplate;
	}
	
	@Bean
	@Autowired
	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory);
		containerFactory.setMessageConverter(jacksonJMSMesageConvertor());
		containerFactory.setConcurrency("1-1");
		// make container factory aware of transaction maanger
		containerFactory.setTransactionManager(jmsTransactionManager());
		// Error handling
		containerFactory.setErrorHandler(t->{
			System.err.println("Handling error in jms listener for messages : "+ t.getMessage());
		});
		
		return containerFactory;
	}
	
	@Bean // Bean for the conversion of message using json 2.0
	public MessageConverter jacksonJMSMesageConvertor() {
		// Usage with jackson 2
		MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
		mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
		mappingJackson2MessageConverter.setTypeIdPropertyName("_type");// doesn't matter if using the same bean
		return mappingJackson2MessageConverter;
	}
	
	// If more than one transaction manager -> then @transactional(transactionalManager = "mytransactional")
	@Bean
	public PlatformTransactionManager jmsTransactionManager() {
		return new JmsTransactionManager(connectionFactory());
	}

}
