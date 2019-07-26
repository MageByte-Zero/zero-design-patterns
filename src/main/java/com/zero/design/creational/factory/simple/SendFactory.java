package com.zero.design.creational.factory.simple;

import com.zero.design.creational.factory.service.SenderService;

/**
 * 工厂类，创建实例对象.缺点当字符串输错则得不到对象
 * @author unique
 *
 */
public class SendFactory {
	
	public SenderService produce(String type) {
		SenderService senderService = null;
		switch (type) {
		case "mail":
			senderService = new MailSenderServiceImpl();
			break;
		case "sms":
			senderService = new SmsSenderServiceImpl();
			break;
		default:
			System.out.println("请输入正确类型");
			break;
		}
		return senderService;
	}

}
