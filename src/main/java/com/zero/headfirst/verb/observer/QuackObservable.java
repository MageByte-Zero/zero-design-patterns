package com.zero.headfirst.verb.observer;

/**
 * 被观察者：需要管理观察者与通知观察者
 */
public interface QuackObservable {
    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(QuackObserver observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(QuackObserver observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
