package com.zero.design.actions.mediator;

/**
 * 具体同事类：这里的角色是房东
 * Created by ljq97 on 2017/9/24.
 */
public class Landlord extends AbstractColleague {
    public Landlord(AbstractMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    protected void sendMessage(String msg) {
        mediator.operation(this, msg);
    }

    @Override
    protected void getMessage(String msg) {
        System.out.println("房东【" + name + "】收到中介发来的消息:" + msg);
    }
}
