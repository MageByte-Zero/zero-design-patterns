package com.zero.design.creational.factory.service;

/**
 * 产生产品对象接口
 * @author unique
 *
 */
public interface ProviderServiceFactory {
	
	/**
	 * 生成对象
	 * @return
	 */
	public SenderService produce();

}
