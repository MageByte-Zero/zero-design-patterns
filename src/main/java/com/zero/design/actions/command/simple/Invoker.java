package com.zero.design.actions.command.simple;

/**
 * 请求者角色：持有命令对象
 * Created by ljq97 on 2017/8/13.
 */
public class Invoker {

    /**
     * 持有命令角色
     */
    private Command command;

    public Invoker() {
    }

    public Invoker(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行动作
     */
    public void action() {
        System.out.println("请求者发号施令");
        command.execute();
    }
}
