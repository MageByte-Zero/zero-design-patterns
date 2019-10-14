package com.zero.headfirst.verb;

import com.zero.headfirst.verb.adapter.GooseAdapter;
import com.zero.headfirst.verb.decorator.QuackCounter;
import com.zero.headfirst.verb.duck.*;
import com.zero.headfirst.verb.goose.Goose;

/**
 * 模拟器
 */
public class DuckSimulation {
    public static void main(String[] args) {
        DuckSimulation simulation = new DuckSimulation();
        simulation.simulate();
    }

    /**
     * 模拟屏幕展示功能
     */
    private void simulate() {
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable mallarDuck = new QuackCounter(new MallarDuck());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        //不想把天鹅的叫声统计，所以不用装饰器装饰
        GooseAdapter gooseAdapter = new GooseAdapter(new Goose());
        System.out.println("使用装饰器模式后，统计叫的次数，不包含天鹅");

        simulate(redheadDuck);
        simulate(mallarDuck);
        simulate(rubberDuck);
        simulate(duckCall);
        simulate(gooseAdapter);
        System.out.println("一共叫了 " + QuackCounter.getQuacks() + " 次");
    }

    private void simulate(Quackable quackable) {
        quackable.quack();
    }

}
