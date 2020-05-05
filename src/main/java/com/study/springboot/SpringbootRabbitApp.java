package com.study.springboot;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;

/*
 * 基于springboot方式整合rabbitmq.
 * 此项目没有导入springboot-autoconfig的包所以以下部分代码是伪代码。
 */
public class SpringbootRabbitApp {

	public static void main(String[] args) {
		// SpringApplication.run(SpringbootRabbitApp.class, args);
	}

	// 发送消息
//	@Bean
//	public ApplicationRunner runner(AmqpTemplate template) {
//		return args -> template.convertAndSend("myqueue", "foo");
//	}

	// 定义Queue
	@Bean
	public Queue myQueue() {
		return new Queue("myqueue");
	}

	@RabbitListener(queues = "myqueue")
	public void listen(String in) {
		System.out.println(in);
	}
}
