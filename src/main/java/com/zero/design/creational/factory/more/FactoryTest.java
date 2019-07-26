package com.zero.design.creational.factory.more;

import com.zero.design.creational.factory.service.SenderService;

public class FactoryTest {
	
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		SenderService senderService = factory.produceMailService();
		senderService.send("李健青", "你是最棒的！");
	}

}
