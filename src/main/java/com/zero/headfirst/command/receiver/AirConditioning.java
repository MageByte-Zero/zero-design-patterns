package com.zero.headfirst.command.receiver;

/**
 * 空调
 */
public class AirConditioning {
    public void on() {
        System.out.println("打开空调");
    }

    public void off() {
        System.out.println("关闭空调");
    }

    public void setTemperature() {
        System.out.println("空调温度设置28°");
    }
}
