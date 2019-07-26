package com.zero.design.creational.builder;

import com.zero.design.creational.builder.biz.Builder;

import java.util.List;

public class BuilderTest {

	public static void main(String[] args) {
		
		Builder builder = new Builder();
		builder.produceMailSender(5);
		List<SenderService> list = builder.getList();
		System.out.println(list.toString());
	}

}
