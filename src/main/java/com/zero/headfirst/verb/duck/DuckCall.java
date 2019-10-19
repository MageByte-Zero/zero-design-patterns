package com.zero.headfirst.verb.duck;

import com.zero.headfirst.verb.observer.ObservableDelegate;
import com.zero.headfirst.verb.observer.QuackObservable;
import com.zero.headfirst.verb.observer.QuackObserver;

/**
 * 鸭子叫模拟器
 */
public class DuckCall implements Quackable {

    /**
     * 持有 QuackObservable 的引用，将 委托给辅助类实现
     */
    private QuackObservable observableDelegate;

    public DuckCall() {
        // 委托给观察者辅助类
        this.observableDelegate = new ObservableDelegate(this);
    }

    @Override
    public void quack() {
        System.out.println("鸭子模拟器叫...");
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
