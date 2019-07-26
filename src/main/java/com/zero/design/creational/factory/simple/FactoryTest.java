package com.zero.design.creational.factory.simple;

import com.zero.design.creational.factory.service.SenderService;

public class FactoryTest {
	
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		SenderService senderService = factory.produce("mail");
		senderService.send("李健青", "你是最棒的！");
	}

}
