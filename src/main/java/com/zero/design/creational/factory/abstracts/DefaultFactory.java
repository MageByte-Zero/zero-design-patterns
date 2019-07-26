package com.zero.design.creational.factory.abstracts;

import com.zero.design.creational.factory.service.SenderService;

/**
 * @author lijianqing
 * @Type DefaultFactory
 * @Desc 默认工厂
 * @date 2019/2/20 19:02
 * @Version 1.0
 */
public class DefaultFactory extends AbstractFactory {

    /**
     * 不传参数默认工厂
     */
    private MailFactory defaultFactory = new MailFactory();
    @Override
    public SenderService produce() {
        return defaultFactory.produce();
    }
}
