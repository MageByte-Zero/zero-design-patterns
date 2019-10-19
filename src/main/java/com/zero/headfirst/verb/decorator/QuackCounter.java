package com.zero.headfirst.verb.decorator;

import com.zero.headfirst.verb.duck.Quackable;
import com.zero.headfirst.verb.observer.QuackObserver;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 装饰器模式，发出叫声的时候同时记录次数.这样我们就不必修改每个鸭子发出声音的方法
 */
public class QuackCounter implements Quackable {

    private Quackable quack;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public QuackCounter(Quackable quack) {
        this.quack = quack;
    }

    @Override
    public void quack() {
        quack.quack();
        atomicInteger.incrementAndGet();
    }

    public static AtomicInteger getQuacks() {
        return atomicInteger;
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        quack.registerObserver(observer);
    }

    @Override
    public void removeObserver(QuackObserver observer) {
        quack.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quack.notifyObservers();
    }
}
