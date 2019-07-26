package com.zero.design.actions.dutychain;

/**
 * 模拟请求：
 * 他们处理请求的条件是不同的，而且只要不是自己处理范围之内的，就会将请求传给链上的下一位来处理
 * Created by ljq97 on 2017/8/9.
 */
public class Client {

    public static void main(String[] args) {
        //初始化责任链，应该使用单例
        AbstractLeaderHandler directorHandler = new DirectorHandler("张胜男");
        AbstractLeaderHandler managerHandler = new ManagerHandler("李四");
        AbstractLeaderHandler generalManagerHndler = new GeneralManagerHndler("赵王");

        //组织好责任对象关系
        directorHandler.setNextLeaderHandler(managerHandler);
        managerHandler.setNextLeaderHandler(generalManagerHndler);

        //开始请假操作
        LeaveRequest request = new LeaveRequest("倪升武", 15, "在家睡觉");
        directorHandler.handleRequest(request);
    }
}
