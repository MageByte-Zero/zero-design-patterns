package com.zero.headfirst.verb.duck;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式，管理一群鸭子: 对待单个对象一样对待集合对象
 * 组合需要和叶子节点一样实现相同的接口，这里的叶子节点就是 Quackable
 */
public class Flock implements Quackable {

    private List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quackable) {
        quackers.add(quackable);
    }

    @Override
    public void quack() {
        for (Quackable quackable : quackers) {
            quackable.quack();
        }
    }
}