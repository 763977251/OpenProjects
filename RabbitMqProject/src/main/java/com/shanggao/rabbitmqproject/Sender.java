package com.shanggao.rabbitmqproject;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.send("hello", context);
	}


	public void send(String queue, String msg) {
		System.out.println("Sender : " + msg);
		this.rabbitTemplate.convertAndSend(queue, msg);
	}
	public void send(String exchange, String routingKey, String msg) {
		System.out.println("exchange : " + exchange);
		System.out.println("routingKey : " + routingKey);
		System.out.println("Sender : " + msg);
		this.rabbitTemplate.convertAndSend(exchange, routingKey, msg);
	}

}
