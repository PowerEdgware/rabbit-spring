package com.study.javaconfig;

import java.net.URI;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

/*
 * spring annotation方式实现与rabbitmq的整合
 */
public class JavaConfigurationBoot {

	static final String QUEUE_NAME="myqueue";
	public static void main(String[] args) {
		ApplicationContext context=
				new AnnotationConfigApplicationContext(JavaRabbitConfiguration.class);
		AmqpTemplate amqpTemplate=	context.getBean(AmqpTemplate.class);
		
		amqpTemplate.convertAndSend(QUEUE_NAME,"foo");
		
		String foo = (String) amqpTemplate.receiveAndConvert(QUEUE_NAME);
		System.out.println(foo);
		
		((AbstractApplicationContext) context).close();
	}
	
	static class JavaRabbitConfiguration{
		@Bean
		public ConnectionFactory connectionFactory() {
			return new CachingConnectionFactory(URI.create(""));
		}
		@Bean
		public RabbitTemplate rabbitTemplate() {
			return new RabbitTemplate(connectionFactory());
		}
		@Bean
		public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
			return new RabbitAdmin(connectionFactory);
		}
		
		@Bean
		public Queue myQueue() {
			return QueueBuilder.durable(QUEUE_NAME).build();
		}
	}
}
