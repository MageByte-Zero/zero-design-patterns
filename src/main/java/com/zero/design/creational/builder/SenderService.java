/**
 * 
 */
package com.zero.design.creational.builder;

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
	public boolean send(String to, String msg);
	
}
