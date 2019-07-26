package com.zero.design.actions.strategy.simple;

/**
 * 环境角色
 * Created by unique on 2017/5/31.
 */
public class Context {
    /**
     * 持有一个具体策略的对象
     */
    private IStrategy strategy;

    public Context() {
        super();
    }

    /**
     * 通过构造方法实例具体策略
     * @param strategy
     */
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextMethod() {
        strategy.strategyMethod();
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
}
