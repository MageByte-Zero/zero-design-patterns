package com.zero.design.actions.strategy.simple;

/**
 * 具体策略类
 * Created by unique on 2017/5/31.
 */
public class ConcreteStrategyC implements  IStrategy{
    @Override
    public void strategyMethod() {
        System.out.println("this is ConcreteStrategyC strategyMethod()");
    }
}
