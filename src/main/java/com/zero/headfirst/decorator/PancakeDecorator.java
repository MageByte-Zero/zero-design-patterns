package com.zero.headfirst.decorator;

/**
 * 抽象装饰器角色，实现煎饼接口（被装饰器接口），持有被装饰器的引用将烹饪行为转发具体的装饰器。
 */
public abstract class PancakeDecorator implements Pancake {

    private Pancake pancake;

    public PancakeDecorator(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public void cook() {
        if (pancake != null) {
            pancake.cook();
        }
    }
}
