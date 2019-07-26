package com.zero.design.creational.factory.simple;

import com.zero.design.creational.factory.service.SenderService;

public class MailSenderServiceImpl implements SenderService {

	@Override
	public boolean send(String to, String msg) {
		System.out.println("MailSender:收件人：" + to + ",消息为：" + msg);
		return true;
	}

}
