package com.zero.design.actions.command.simple;

/**
 * 客户端角色
 * Created by ljq97 on 2017/8/13.
 */
public class Client {
    public static void main(String[] args) {
        //创建接收者，其实就是实际执行逻辑
        Receiver receiver = new Receiver();
        //创建命令对象，设定命令接收者
        Command command = new ConcreteCommand(receiver);
        //创建请求者，设置命令的执行者,并发号施令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);

        //执行行动，内部调用命令执行者的动作逻辑
        invoker.action();
    }
}
