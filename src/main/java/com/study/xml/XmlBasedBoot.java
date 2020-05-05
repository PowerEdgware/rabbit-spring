package com.study.xml;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 基于xml方式整合spring-rabbitmq
 */
public class XmlBasedBoot {

	public static void main(String[] args) {
		ApplicationContext context=new 
				GenericXmlApplicationContext("classpath:rabbit-context.xml");
		AmqpTemplate amqpTemplate=context.getBean(AmqpTemplate.class);
//		RabbitTemplate
		//发送数据到默认交换机和队列
		amqpTemplate.convertAndSend("myqueue", "foobar");
		
		String fooMsg=(String) amqpTemplate.receiveAndConvert
				(TimeUnit.SECONDS.toMillis(3));
		System.out.println(fooMsg);
		
		//close
		((GenericXmlApplicationContext)context).close();
	}
}
