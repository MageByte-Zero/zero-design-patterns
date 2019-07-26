package com.zero.headfirst.observer;

public interface NewspaperSubject {
    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     * @param data
     */
    void notifyObservers(Newspaper data);
}
