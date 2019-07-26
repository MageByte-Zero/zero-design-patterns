package com.zero.design.actions.observers.simple;

import java.util.ArrayList;

/**
 * 天气主题:实现主题接口
 * Created by jianqing.li on 2017/6/8.
 */
public class WeatherDataSubject implements Subject {

    // 我们加上一个ArrayList来记录观察者，此ArrayList是在构造器中建立的。
    public ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataSubject() {
        this.observers = new ArrayList();
    }

    /**
     * 注册观察者
     *
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * 移除观察者
     *
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        int indexOf = observers.indexOf(o);
        if (indexOf >= 0) {
            observers.remove(o);
        }
    }

    /**
     * 通知观察者:当主题状态改变时。这个方法会被调用，以通知所有的观察者
     * 调用观察者的update从而通知
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    // 当从气象站得到更新观测值时，我们通知观察者
    public void measurementsChanged(){
        notifyObservers();
    }

    /**
     * 气象信息变化:触发主题通知
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        //通知所有注册的观察者
        measurementsChanged();
    }
}
