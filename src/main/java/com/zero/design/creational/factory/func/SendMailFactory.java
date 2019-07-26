package com.zero.design.creational.factory.func;

import com.zero.design.creational.factory.service.ProviderServiceFactory;
import com.zero.design.creational.factory.service.SenderService;
import com.zero.design.creational.factory.simple.MailSenderServiceImpl;

public class SendMailFactory implements ProviderServiceFactory {

	@Override
	public SenderService produce() {
		return new MailSenderServiceImpl();
	}

}
