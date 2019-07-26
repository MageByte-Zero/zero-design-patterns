package com.zero.design.actions.delegation;

/**
 * 员工B执行的任务
 */
public class ExcuterB implements IExcuter {
    @Override
    public void execute(String command) {
        System.out.println("员工B 开始做" + command + "的工作");
    }
}