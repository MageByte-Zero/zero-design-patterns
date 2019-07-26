package com.zero.headfirst.decorator;

/**
 * 被装饰对象：定义最基本的乞丐版煎饼，啥都没加
 */
public class BeggarPancake implements Pancake {
    @Override
    public void cook() {
        System.out.println("乞丐版基本煎饼");
    }
}
