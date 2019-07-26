package com.zero.design.actions.command.audioplayer;

/**
 * 抽象命令类角色,让所有具体命令实现
 * Created by ljq97 on 2017/8/13.
 */
public interface Command {

    /**
     * 执行方法
     */
    void execute();
}
