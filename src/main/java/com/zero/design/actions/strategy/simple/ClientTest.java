package com.zero.design.actions.strategy.simple;

/**
 * Created by unique on 2017/5/31.
 */
public class ClientTest {
    public static void main(String[] args) {
        Context context = new Context();

        IStrategy strategy = new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.contextMethod();

        strategy = new ConcreteStrategyB();
        context.setStrategy(strategy);
        context.contextMethod();
    }
}
