package com.zero.design.structural.decorator;

/**
 * Created by unique on 2017/5/14.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.method();
    }
}
