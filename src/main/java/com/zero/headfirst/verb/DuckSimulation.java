package com.zero.headfirst.verb;

import com.zero.headfirst.verb.adapter.GooseAdapter;
import com.zero.headfirst.verb.decorator.QuackCounter;
import com.zero.headfirst.verb.duck.*;
import com.zero.headfirst.verb.factory.AbstractDuckFactory;
import com.zero.headfirst.verb.factory.DuckCountFactory;
import com.zero.headfirst.verb.factory.DuckFactory;
import com.zero.headfirst.verb.goose.Goose;

/**
 * 模拟器
 */
public class DuckSimulation {
    public static void main(String[] args) {
        DuckSimulation simulation = new DuckSimulation();
        AbstractDuckFactory duckCountFactory = new DuckCountFactory(new DuckFactory());
        simulation.simulate(duckCountFactory);
    }

    /**
     * 模拟屏幕展示功能
     */
    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable mallarDuck = duckFactory.createMallarDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        //不想把天鹅的叫声统计，所以不用装饰器装饰
        GooseAdapter gooseAdapter = new GooseAdapter(new Goose());
        System.out.println("----使用装饰器模式后，统计叫的次数，不包含天鹅,同时使用了工厂模式产生鸭子---");

        System.out.println("--使用组合模式管理鸭子群--");
        // 主要鸭子群
        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(mallarDuck);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(gooseAdapter);
        // 绿头鸭群
        Flock mallarFlock = new Flock();

        Quackable mallarDuck1 = duckFactory.createMallarDuck();
        Quackable mallarDuck2 = duckFactory.createMallarDuck();
        Quackable mallarDuck3 = duckFactory.createMallarDuck();
        Quackable mallarDuck4 = duckFactory.createMallarDuck();
        mallarFlock.add(mallarDuck1);
        mallarFlock.add(mallarDuck2);
        mallarFlock.add(mallarDuck3);
        mallarFlock.add(mallarDuck4);

        System.out.println("----主要鸭子群模拟器----");
        simulate(flockOfDucks);
        System.out.println("---绿头鸭群模拟---");
        simulate(mallarFlock);
        System.out.println("一共叫了 " + QuackCounter.getQuacks() + " 次");
    }

    private void simulate(Quackable quackable) {
        quackable.quack();
    }

}
