package com.zero.design.creational.factory.summarize;

import com.zero.design.creational.factory.service.ProviderServiceFactory;
import com.zero.design.creational.factory.service.SenderService;

public class SmsSenderServiceImpl implements SenderService {
	
	public static ProviderServiceFactory factory = new ProviderServiceFactory() {
		
		@Override
		public SenderService produce() {
			return new SmsSenderServiceImpl();
		}
	};

	@Override
	public boolean send(String to, String msg) {
		System.out.println("SmsSender:收件人：" + to + ",消息为：" + msg);
		return true;
	}

}
