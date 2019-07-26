package com.zero.design.creational.factory.abstracts;

import com.zero.design.creational.factory.service.SenderService;
import com.zero.design.creational.factory.simple.MailSenderServiceImpl;

/**
 * @author lijianqing
 * @Type MailFactory
 * @Desc
 * @date 2019/2/20 19:00
 * @Version 1.0
 */
public class MailFactory extends AbstractFactory {
    @Override
    public SenderService produce() {
        return new MailSenderServiceImpl();
    }
}
