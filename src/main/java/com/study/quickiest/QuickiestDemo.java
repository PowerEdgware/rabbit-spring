package com.study.quickiest;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class QuickiestDemo {

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new CachingConnectionFactory();
		
		AmqpAdmin admin = new RabbitAdmin(connectionFactory);
		//默认是队列和默认的direct类型的交换机绑定并且binding key就是队列名称myqueue
		admin.declareQueue(new Queue("myqueue"));
		AmqpTemplate template = new RabbitTemplate(connectionFactory);
		//发送时指定队列名称为routing key
		template.convertAndSend("myqueue", "foo");
		String foo = (String) template.receiveAndConvert("myqueue");
		System.out.println(foo);
	}
}
