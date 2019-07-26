package com.zero.design.actions.observers.simple;

/**
 * Created by jianqing.li on 2017/6/8.
 */
public class WeatherStation {
    public static void main(String[] args) {

        // 建立目前状况布告板,构造方法注册观察者
        for (int i = 0; i < 4; i++) {
            // 建立WeatherData主题对象
            WeatherDataSubject weatherData = new WeatherDataSubject();
            //注册观察者
            new CurrentConditionsDisplay(weatherData);

            //主题发布新消息
            weatherData.setMeasurements(80, 65, 30.4f);
            weatherData.setMeasurements(82, 70, 29.2f);
            weatherData.setMeasurements(78, 90, 29.2f);
        }

    }
}
