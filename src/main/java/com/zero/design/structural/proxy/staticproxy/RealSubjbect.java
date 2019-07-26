package com.zero.design.structural.proxy.staticproxy;

/**
 * 真实角色
 * Created by unique on 2017/5/14.
 */
public class RealSubjbect extends AbstractSubject {

    @Override
    public void request() {
        System.out.println("this is RealSubjbect.request()");
    }
}
