package com.zero.design.actions.delegation;

/**
 * @Project: spring
 * @description: boss  模拟客户执行任务
 * @ModificationHistory who      when       What
 **/
public class Boss {
    public static void main(String[] args) {
        Leader leader = new Leader();
        //看上去好像是我们的项目经理在干活
        //但实际干活的人是普通员工
        //这就是典型，干活是我的，功劳是你的
        leader.execute("登录");
        leader.execute("加密");
    }
}