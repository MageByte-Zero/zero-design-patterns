/**
 * Project: com-zero-design-stu
 * File created at 2019/5/29 17:31
 */
package com.zero.headfirst.strategy;

/**
 * 会叫的具体实现
 * @author lijianqing
 * @version 1.0
 * @ClassName Quack
 * @date 2019/5/29 17:31
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
