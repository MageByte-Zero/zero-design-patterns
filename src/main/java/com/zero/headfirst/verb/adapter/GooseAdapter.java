package com.zero.headfirst.verb.adapter;

import com.zero.headfirst.verb.duck.Quackable;
import com.zero.headfirst.verb.goose.Goose;

/**
 * 将天鹅适配成鸭子
 */
public class GooseAdapter implements Quackable {
    /**
     * 持有被修饰的对象
     */
    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
