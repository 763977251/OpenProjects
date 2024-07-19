package com.shanggao.rabbitmqproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitMqProjectApplicationTests {
	@Autowired
	private Sender sender;

	@Test
	public void hello() throws Exception {
		sender.send();
	}
}
