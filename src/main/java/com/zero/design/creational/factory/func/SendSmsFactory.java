package com.zero.design.creational.factory.func;

import com.zero.design.creational.factory.service.ProviderServiceFactory;
import com.zero.design.creational.factory.service.SenderService;
import com.zero.design.creational.factory.simple.SmsSenderServiceImpl;

public class SendSmsFactory implements ProviderServiceFactory {

	@Override
	public SenderService produce() {
		return new SmsSenderServiceImpl();
	}

}
