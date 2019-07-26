package com.zero.design.actions.command.simple;

/**
 * 具体命令角色,持有对应的接收者。从而执行命令
 * Created by ljq97 on 2017/8/10.
 */
public class ConcreteCommand implements Command {

    /**
     * 持有相应的接收者对象
     */
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("接收者收到指令");
        //通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }
}
