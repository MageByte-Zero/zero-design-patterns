/**
 * Project: com-zero-design-stu
 * File created at 2019/5/29 17:34
 */
package com.zero.headfirst.strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {

        //定义不会叫不会飞的鸭子
        FlyBehavior flyBehavior = new FlyNoWay();
        QuackBehavior quackBehavior = new MuteQuack();
        Duck modelDuck = new ModelDuck();
        //这里我们可以设置不同的行为实现类就会执行不同的策略
        modelDuck.setFlyBehavior(flyBehavior);
        modelDuck.setQuackBehavior(quackBehavior);

        modelDuck.display();
        modelDuck.performFly();
        modelDuck.performQuack();
        System.out.println("-------------------");

        // 定义会叫会飞的鸭子
        FlyBehavior flyWithWings = new FlyWithWings();
        QuackBehavior quack = new Quack();
        Duck mallardDuck = new MallardDuck();

        mallardDuck.setFlyBehavior(flyWithWings);
        mallardDuck.setQuackBehavior(quack);

        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();

    }
}
