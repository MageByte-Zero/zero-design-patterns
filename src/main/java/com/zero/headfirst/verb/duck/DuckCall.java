package com.zero.headfirst.verb.duck;

/**
 * 鸭子叫模拟器
 */
public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("鸭子模拟器叫...");
    }
}
