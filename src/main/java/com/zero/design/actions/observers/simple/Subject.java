package com.zero.design.actions.observers.simple;

/**
 * 这是主题接口，对象使用此接口注册为观察者，或者把自己从观察者中删除
 * Created by jianqing.li on 2017/6/8.
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知观察者:当主题状态改变时。这个方法会被调用，以通知所有的观察者
     */
    void notifyObservers();
}
