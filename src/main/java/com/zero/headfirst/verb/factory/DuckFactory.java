package com.zero.headfirst.verb.factory;

import com.zero.headfirst.verb.duck.*;

/**
 * 每个方法创建一种产品，一种特定种类的 Quackable
 */
public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createMallarDuck() {
        return new MallarDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
