package com.zero.headfirst.verb.duck;

import com.zero.headfirst.verb.observer.ObservableDelegate;
import com.zero.headfirst.verb.observer.QuackObservable;
import com.zero.headfirst.verb.observer.QuackObserver;

public class RedheadDuck implements Quackable {

    private QuackObservable observableDelegate;

    public RedheadDuck() {
        this.observableDelegate = new ObservableDelegate(this);
    }
    @Override
    public void quack() {
        System.out.println("红头鸭呱呱叫...");
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
