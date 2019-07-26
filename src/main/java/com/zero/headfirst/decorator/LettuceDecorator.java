package com.zero.headfirst.decorator;

/**
 * 生菜装饰器
 */
public class LettuceDecorator extends PancakeDecorator {

    public LettuceDecorator(Pancake pancake) {
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加生菜；");
        super.cook();
    }

}
