package com.zero.design.actions.mediator;

/**
 * 抽象同事类：与中介者通信
 * Created by ljq97 on 2017/9/24.
 */
public abstract class AbstractColleague {

    /**
     * 持有抽象中介者的引用
     */
    protected AbstractMediator mediator;

    protected String name;

    public AbstractColleague(AbstractMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public AbstractMediator getMediator() {
        return mediator;
    }

    /**
     * 设置中介者对象
     * @param mediator
     */
    public void setMediator(AbstractMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 向中介者发送消息
     * @param msg
     */
    protected abstract void sendMessage(String msg);

    /**
     * 从中介者获取信息
     * @param msg
     */
    protected abstract void getMessage(String msg);
}
