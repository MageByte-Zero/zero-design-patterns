package com.zero.design.structural.facade;

/**
 * 客户端
 * Created by unique on 2017/5/14.
 */
public class UserClient {

    public static void main(String[] args) {
        ComputerFacade facade = ComputerFacade.getInstance();
        facade.startup();
        System.out.println("时间到了，可以关机了.....");
        facade.shutdown();

        ComputerFacade facade2 = ComputerFacade.getInstance();

        System.out.println(facade.getCpu() + "," + facade2.getCpu());;
    }
}
