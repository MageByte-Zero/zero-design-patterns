/**
 * Project: com-zero-design-stu
 * File created at 2019/5/29 17:32
 */
package com.zero.headfirst.strategy;

/**
 * 不会叫的具体实现
 * @author lijianqing
 * @version 1.0
 * @ClassName MuteQuack
 * @date 2019/5/29 17:32
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我不会叫");
    }
}
