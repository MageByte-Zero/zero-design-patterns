package com.zero.headfirst.verb.duck;

import com.zero.headfirst.verb.observer.QuackObservable;

/**
 * 呱呱叫接口，继承被观察者接口，让所有实现了 Quackable 的实现类能够扮演被观察者
 */
public interface Quackable extends QuackObservable {
    /**
     * 呱呱叫
     */
    void quack();
}
