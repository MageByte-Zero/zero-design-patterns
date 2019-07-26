/**
 * 
 */
package com.zero.design.creational.factory.service;

/**
 * @author unique
 * 创建二者共同接口
 */
public interface SenderService {
	
	/**
	 * 发送信息
	 * @param to 收件人
	 * @param msg 消息
	 * @return
	 */
	boolean send(String to, String msg);
	
}
