package com.zero.design.actions.command.simple;

/**
 * 接收者角色
 * Created by ljq97 on 2017/8/10.
 */
public class Receiver {

    /**
     * 真正执行命令的对应逻辑
     */
    public void action() {
        System.out.println("接收者执行命令");
    }
}
