package com.shanggao.rabbitmqproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 10699518
 * @Description: TODO
 */
@RestController
@RequiredArgsConstructor
public class SenderController {

	private final Sender sender;

	/**
	 * 发送消息
	 * @param queue 队列
	 * @param msg 消息内容
	 * @return
	 */
	@GetMapping("/sendMsg")
	public String sendMessage(String queue, String msg) {
		sender.send(queue, msg);
		return "success";
	}
	/**
	 * 发送消息exchange
	 * @return
	 */
	@GetMapping("/sendMsgExchange")
	public String sendMessage(String exchange, String routingKey, String msg) {
		sender.send(exchange, routingKey, msg);
		return "success";
	}
}
