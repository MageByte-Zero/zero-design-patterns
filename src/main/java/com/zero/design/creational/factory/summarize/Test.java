package com.zero.design.creational.factory.summarize;

import com.zero.design.creational.factory.service.SenderService;

public class Test {

	public static void main(String[] args) {
		SenderService senderService = SmsSenderServiceImpl.factory.produce();
		senderService.send("李健青", "你是最棒的！");
	}

}
