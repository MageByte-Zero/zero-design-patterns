package com.zero.design.structural.proxy.staticproxy;

/**
 * Created by unique on 2017/5/14.
 */
public class Test {

    public static void main(String[] args) {
        AbstractSubject subject = new ProxySubject();
        subject.request(); //代理者代替真实者做事情
    }
}
