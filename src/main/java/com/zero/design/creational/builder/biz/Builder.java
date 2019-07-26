package com.zero.design.creational.builder.biz;

import com.zero.design.creational.builder.MailSenderServiceImpl;
import com.zero.design.creational.builder.SenderService;
import com.zero.design.creational.builder.SmsSenderServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 与工厂模式的区别：工厂模式关注的创建单个产品，创建者模式关注符合对象，多个部分。
 * @author unique
 *
 */
public class Builder {
	
	private List<SenderService> list = new ArrayList<SenderService>();
	
	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSenderServiceImpl());
		}
	}
	
	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SmsSenderServiceImpl());
		}
	}

	public List<SenderService> getList() {
		return list;
	}

	public void setList(List<SenderService> list) {
		this.list = list;
	}
	

}
