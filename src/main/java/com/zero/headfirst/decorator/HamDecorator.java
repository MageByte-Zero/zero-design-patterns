package com.zero.headfirst.decorator;

/**
 * 火腿装饰器
 */
public class HamDecorator extends PancakeDecorator {

    public HamDecorator(Pancake pancake) {
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加一个火腿;");
        super.cook();
    }

}
