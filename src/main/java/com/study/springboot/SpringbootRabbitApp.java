package com.study.springboot;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;

/*
 * ����springboot��ʽ����rabbitmq.
 * ����Ŀû�е���springboot-autoconfig�İ��������²��ִ�����α���롣
 */
public class SpringbootRabbitApp {

	public static void main(String[] args) {
		// SpringApplication.run(SpringbootRabbitApp.class, args);
	}

	// ������Ϣ
//	@Bean
//	public ApplicationRunner runner(AmqpTemplate template) {
//		return args -> template.convertAndSend("myqueue", "foo");
//	}

	// ����Queue
	@Bean
	public Queue myQueue() {
		return new Queue("myqueue");
	}

	@RabbitListener(queues = "myqueue")
	public void listen(String in) {
		System.out.println(in);
	}
}
