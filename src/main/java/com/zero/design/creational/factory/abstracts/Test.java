package com.zero.design.creational.factory.abstracts;

import com.zero.design.creational.factory.service.SenderService;

/**
 * @author lijianqing
 * @Type Test
 * @Desc
 * @date 2019/2/20 19:04
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        DefaultFactory defaultFactory = new DefaultFactory();
        SenderService produce = defaultFactory.produce();
        SenderService mail = defaultFactory.produce("sms");
        produce.send("李健青", "你是最棒的！");
        mail.send("李健青", "你是最棒的！");
    }
}
