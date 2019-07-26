package com.zero.design.structural.decorator;

/**
 * 被装饰类：与装饰类实现同一接口
 * Created by unique on 2017/5/14.
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
