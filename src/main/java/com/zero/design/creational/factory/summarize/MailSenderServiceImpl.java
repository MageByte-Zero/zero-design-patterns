package com.zero.design.creational.factory.summarize;

import com.zero.design.creational.factory.service.ProviderServiceFactory;
import com.zero.design.creational.factory.service.SenderService;

public class MailSenderServiceImpl implements SenderService {
	
	/**
	 * 用匿名内部类方式替换抽象工厂模式的写法abstacts
	 */
	public static ProviderServiceFactory factory = new ProviderServiceFactory() {
		
		@Override
		public SenderService produce() {
			return new MailSenderServiceImpl();
		}
	};

	@Override
	public boolean send(String to, String msg) {
		System.out.println("MailSender:收件人：" + to + ",消息为：" + msg);
		return true;
	}

}
