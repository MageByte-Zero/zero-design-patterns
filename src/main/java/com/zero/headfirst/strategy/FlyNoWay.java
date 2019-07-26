/**
 * Project: com-zero-design-stu
 * File created at 2019/5/29 17:21
 */
package com.zero.headfirst.strategy;

/**
 * 不会飞行的鸭子行为实现
 * @author lijianqing
 * @version 1.0
 * @ClassName FlyNoWay
 * @date 2019/5/29 17:21
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("老司机带带我，我不会飞");
    }
}
