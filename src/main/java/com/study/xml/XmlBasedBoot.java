package com.study.xml;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * ����xml��ʽ����spring-rabbitmq
 */
public class XmlBasedBoot {

	public static void main(String[] args) {
		ApplicationContext context=new 
				GenericXmlApplicationContext("classpath:rabbit-context.xml");
		AmqpTemplate amqpTemplate=context.getBean(AmqpTemplate.class);
//		RabbitTemplate
		//�������ݵ�Ĭ�Ͻ������Ͷ���
		amqpTemplate.convertAndSend("myqueue", "foobar");
		
		String fooMsg=(String) amqpTemplate.receiveAndConvert
				(TimeUnit.SECONDS.toMillis(3));
		System.out.println(fooMsg);
		
		//close
		((GenericXmlApplicationContext)context).close();
	}
}
