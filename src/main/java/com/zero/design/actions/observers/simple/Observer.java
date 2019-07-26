package com.zero.design.actions.observers.simple;

/**
 * 观察者：所有潜在的观察者必须实现观察者接口，这个接口只有update()一个方法，当主题状态改变时它被调用
 * ,从而获取到主题发布的新内容
 * Created by jianqing.li on 2017/6/8.
 */
public interface Observer {
    /**
     * 当气象观测值改变时，主题会把温度、湿度、气压的状态值当作方法的参数，传送给观察者
     * @param temp
     * @param humidity
     * @param pressure
     */
    void update(float temp, float humidity, float pressure);
}
