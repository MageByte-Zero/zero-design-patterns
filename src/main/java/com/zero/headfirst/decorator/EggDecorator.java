package com.zero.headfirst.decorator;

/**
 * 鸡蛋装饰器：覆盖cook方法，加入自身的实现，并且调用父类的cook方法，也就是构造函数中
 * EggDecorator(Pancake pancake)，这里传入的pancake的cook操作
 */
public class EggDecorator extends PancakeDecorator {
    public EggDecorator(Pancake pancake) {
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加一个鸡蛋；");
        super.cook();
    }
}
