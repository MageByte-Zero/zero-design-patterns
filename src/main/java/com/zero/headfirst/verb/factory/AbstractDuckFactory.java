package com.zero.headfirst.verb.factory;

import com.zero.headfirst.verb.duck.Quackable;

/**
 * 抽象工厂模式，定义产品族
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createDuckCall();
    public abstract Quackable createMallarDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createRubberDuck();
}
