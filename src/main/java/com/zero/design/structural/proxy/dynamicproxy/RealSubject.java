package com.zero.design.structural.proxy.dynamicproxy;

/**
 * 真实角色
 * 实现接口
 * Created by unique on 2017/5/14.
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("this is RealSubject.request()!");
    }
}
