/**
 * Project: com-zero-design-stu
 * File created at 2019/5/29 17:10
 */
package com.zero.headfirst.strategy;

/**
 * 抽象鸭子：将变化的两个行为通过组合方式作为鸭子的属性。持有策略类的引用
 * @author lijianqing
 * @version 1.0
 * @ClassName Duck
 * @date 2019/5/29 17:10
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    /**
     * 展示鸭子
     */
    public abstract void display();


    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
