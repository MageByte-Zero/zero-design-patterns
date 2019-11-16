package com.zero.headfirst.verb.observer;

/**
 * 呱呱叫观察者，观察感兴趣的鸭子
 */
public class Quackologist implements QuackObserver {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked。");
    }
}
