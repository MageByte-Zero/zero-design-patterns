package com.zero.headfirst.verb.observer;

/**
 * 鸭子观察者,当被通知的时候执行update
 */
public interface QuackObserver {
    /**
     * @param duck 正在呱呱叫的对象
     */
    void update(QuackObservable duck);
}
