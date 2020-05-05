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
		//Ĭ���Ƕ��к�Ĭ�ϵ�direct���͵Ľ������󶨲���binding key���Ƕ�������myqueue
		admin.declareQueue(new Queue("myqueue"));
		AmqpTemplate template = new RabbitTemplate(connectionFactory);
		//����ʱָ����������Ϊrouting key
		template.convertAndSend("myqueue", "foo");
		String foo = (String) template.receiveAndConvert("myqueue");
		System.out.println(foo);
	}
}
