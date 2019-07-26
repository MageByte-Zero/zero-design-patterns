package com.zero.design.creational.factory.steady;

import com.zero.design.creational.factory.service.SenderService;
import com.zero.design.creational.factory.simple.MailSenderServiceImpl;
import com.zero.design.creational.factory.simple.SmsSenderServiceImpl;

/**
 * 工厂类，创建实例对象.缺点当字符串输错则得不到对象
 * @author unique
 *
 */
public class SendFactory {
	
	public static SenderService produceSmsService() {
		return new SmsSenderServiceImpl();
	}
	
	public static SenderService produceMailService() {
		return new MailSenderServiceImpl();
	}

}
