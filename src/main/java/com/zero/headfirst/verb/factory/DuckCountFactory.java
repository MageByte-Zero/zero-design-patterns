package com.zero.headfirst.verb.factory;

import com.zero.headfirst.verb.decorator.QuackCounter;
import com.zero.headfirst.verb.duck.*;

/**
 * 叫声计数器工厂:同时还结合了装饰器模式，持有 工厂引用
 */
public class DuckCountFactory extends AbstractDuckFactory {

    private AbstractDuckFactory duckFactory;

    public DuckCountFactory(DuckFactory duckFactory) {
        this.duckFactory = duckFactory;
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(duckFactory.createDuckCall());
    }

    @Override
    public Quackable createMallarDuck() {
        return new QuackCounter(duckFactory.createMallarDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(duckFactory.createRedheadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(duckFactory.createRubberDuck());
    }
}
