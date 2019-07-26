package com.zero.headfirst.command.receiver;

public class TV {
    public void on() {
        System.out.println("打开电视");
    }

    public void off() {
        System.out.println("关闭电视");
    }

    public void setChannel() {
        System.out.println("设置频道为宇宙电视台");
    }

    public void setVolume() {
        System.out.println("电视音量设置为20");
    }
}
