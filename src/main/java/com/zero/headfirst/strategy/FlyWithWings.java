/**
 * Project: com-zero-design-stu
 * File created at 2019/5/29 17:18
 */
package com.zero.headfirst.strategy;

/**
 * 会飞的鸭子行为实现
 * @author lijianqing
 * @version 1.0
 * @ClassName FlyWithWings
 * @date 2019/5/29 17:18
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我会飞行，一冲云霄");
    }
}
