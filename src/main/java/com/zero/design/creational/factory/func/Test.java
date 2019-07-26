package com.zero.design.creational.factory.func;

import com.zero.design.creational.factory.service.ProviderServiceFactory;
import com.zero.design.creational.factory.service.SenderService;

public class Test {

	public static void main(String[] args) {
		ProviderServiceFactory provider = new SendMailFactory();
		SenderService senderService = provider.produce();
		senderService.send("李健青", "你是最棒的！");
	}

}
