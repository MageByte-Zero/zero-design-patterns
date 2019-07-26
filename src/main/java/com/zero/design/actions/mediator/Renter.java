package com.zero.design.actions.mediator;

/**
 * 具体同事类：这里的角色是求租者
 * Created by ljq97 on 2017/9/24.
 */
public class Renter extends AbstractColleague {


    public Renter(AbstractMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    protected void sendMessage(String msg) {
        mediator.operation(this, msg);
    }

    @Override
    protected void getMessage(String msg) {
        System.out.println("求租者【" + name + "】收到中介发来的消息:" + msg);
    }
}
