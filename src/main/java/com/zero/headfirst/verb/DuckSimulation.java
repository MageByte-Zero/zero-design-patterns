package com.zero.headfirst.verb;

import com.zero.headfirst.verb.adapter.GooseAdapter;
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
        Quackable redheadDuck = new RedheadDuck();
        Quackable mallarDuck = new MallarDuck();
        Quackable rubberDuck = new RubberDuck();
        Quackable duckCall = new DuckCall();
        GooseAdapter gooseAdapter = new GooseAdapter(new Goose());
        simulate(redheadDuck);
        simulate(mallarDuck);
        simulate(rubberDuck);
        simulate(duckCall);
        simulate(gooseAdapter);
    }

    private void simulate(Quackable quackable) {
        quackable.quack();
    }

}
