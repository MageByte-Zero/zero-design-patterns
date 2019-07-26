package com.zero.design.structural.decorator;

/**
 * 装饰类：持有被装饰类的实例
 * Created by unique on 2017/5/14.
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    /**
     * 由于实现了同一接口：所以可以动态改编方法
     */
    @Override
    public void method() {
        System.out.println("before mothed");
        source.method();
        System.out.println("after mothed");
    }
}
