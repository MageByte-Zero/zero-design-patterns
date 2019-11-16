package com.zero.headfirst.verb.adapter;

import com.zero.headfirst.verb.duck.Quackable;
import com.zero.headfirst.verb.goose.Goose;
import com.zero.headfirst.verb.observer.ObservableDelegate;
import com.zero.headfirst.verb.observer.QuackObservable;
import com.zero.headfirst.verb.observer.QuackObserver;

/**
 * 将天鹅适配成鸭子
 */
public class GooseAdapter implements Quackable {
    /**
     * 持有被修饰的对象
     */
    private Goose goose;

    private QuackObservable observableDelegate;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        observableDelegate = new ObservableDelegate(this);
    }

    @Override
    public void quack() {
        goose.honk();
        //当呱呱叫的时候让观察者知道
        notifyObservers();
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        observableDelegate.registerObserver(observer);
    }

    @Override
    public void removeObserver(QuackObserver observer) {
        observableDelegate.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observableDelegate.notifyObservers();
    }
}
