
package com.zero.design.creational.factory.abstracts;

import com.zero.design.creational.factory.service.SenderService;

/**
 * @author lijianqing
 * @Type AbstractFactory
 * @Desc 抽象工厂方法，实际就是工厂方法与抽象结合
 * @date 2019/2/20 18:57
 * @Version 1.0
 */
public abstract class AbstractFactory {

    /**
     * 抽象生产方法，有不同字类实现
     * @return
     */
    public abstract SenderService produce();

    /**
     * 默认实现,动态配置拓展
     * @param type
     * @return
     */
    public SenderService produce(String type) {
        SenderService senderService = null;
        switch (type) {
            case "mail":
                senderService = new MailFactory().produce();
                break;
            case "sms":
                senderService = new SmsFactory().produce();
                break;
            default:
                System.out.println("请输入正确类型");
                break;
        }
        return senderService;
    }
}
