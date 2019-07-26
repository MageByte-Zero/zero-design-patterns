package com.zero.design.creational.factory.abstracts;

import com.zero.design.creational.factory.service.SenderService;
import com.zero.design.creational.factory.simple.SmsSenderServiceImpl;

/**
 * @author lijianqing
 * @Type SmsFactory
 * @Desc
 * @date 2019/2/20 19:01
 * @Version 1.0
 */
public class SmsFactory extends AbstractFactory {
    @Override
    public SenderService produce() {
        return new SmsSenderServiceImpl();
    }
}
