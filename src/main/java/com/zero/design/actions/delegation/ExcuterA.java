package com.zero.design.actions.delegation;

/**
 * 员工A执行的工作
 */
public class ExcuterA implements IExcuter {

    @Override
    public void execute(String command) {
        System.out.println("员工A 开始做" + command + "的工作");
    }
}