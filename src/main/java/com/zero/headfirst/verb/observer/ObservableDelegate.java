package com.zero.headfirst.verb.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现被观察者接口，与 QuackObservable 组合在一起，这样我们只需要一份代码，QuackObservable 的所有调用都委托给
 * Observable 辅助类
 */
public class ObservableDelegate implements QuackObservable {

    private List<QuackObserver> observerList = new ArrayList<>();

    private QuackObservable duck;

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public ObservableDelegate(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            observerList.add(observer);
        } finally {
            writeLock.unlock();
        }

    }

    @Override
    public void removeObserver(QuackObserver observer) {
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            observerList.remove(observer);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void notifyObservers() {
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.lock();
        try {
            observerList.forEach(item -> item.update(duck));
        } finally {
            readLock.unlock();
        }
    }
}
