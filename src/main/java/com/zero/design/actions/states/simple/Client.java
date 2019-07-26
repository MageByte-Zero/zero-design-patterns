package com.zero.design.actions.states.simple;

/**
 * 客户端类
 * Created by ljq97 on 2017/8/20.
 */
public class Client {
    public static void main(String[] args) {
        //创建状态
        IState stateA = new ConcreteStateA();
        // 创建环境
        Context context = new Context();
        //将状态设置董环境中
        context.setState(stateA);
        // 请求
        context.request("test A");

        ConcreteStateB concreteStateB = new ConcreteStateB();
        context.setState(concreteStateB);
        context.request("test B");
    }
}
