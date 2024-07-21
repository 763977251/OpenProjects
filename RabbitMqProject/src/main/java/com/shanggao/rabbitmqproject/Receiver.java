package com.shanggao.rabbitmqproject;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

//	@RabbitListener(bindings = {
//			@QueueBinding(
//					value = @Queue(name = "hello"),
//					exchange = @Exchange(name = "(AMQP default)")
//			)
//	})
//	public void process(String hello) {
//		System.out.println("Receiver : " + hello);
//	}

//	@RabbitListener(bindings = {
//			@QueueBinding(
//					value = @Queue(name = "HUMAM.XYG.HS.CSC0607.PRD.SVR"),
//					exchange = @Exchange(name = "HUMAM.CSC0607.PRD.SVR"),
//					key = {"HUMAM.CSC0607.PRD.SVR"}
//			)
//	})
//	public void toCSC(String msg) {
//		System.out.println("toCSCReceiver : " + msg);
//	}
	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue(name = "HUMAM.XYG.HS.QMG07.PRD.SVR"),
					exchange = @Exchange(name = "HUMAM.QMG07.PRD.SVR"),
					key = {"HUMAM.QMG07.PRD.SVR"}
			)
	})
	public void toCSC(String msg) {
		System.out.println("toCSCReceiver : " + msg);
	}
//
//	@RabbitListener(bindings = {
//			@QueueBinding(
//					value = @Queue(name = "XYG.HS.WMS.PRD.CNXsvr"),
//					exchange = @Exchange(name = "WMS.PRD.SVR"),
//					key = {"WMS.PRD.OIC.CNXsvr"}
//			)
//	})
//	public void toWMS(String msg) {
//		System.out.println("toWMSReceiver : " + msg);
//	}

}
