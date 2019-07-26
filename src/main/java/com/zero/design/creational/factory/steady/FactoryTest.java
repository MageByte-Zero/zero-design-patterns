package com.zero.design.creational.factory.steady;

import com.zero.design.creational.factory.service.SenderService;

public class FactoryTest {
	
	public static void main(String[] args) {
		SenderService senderService = SendFactory.produceMailService();
		senderService.send("李健青", "你是最棒的！");
	}

}
