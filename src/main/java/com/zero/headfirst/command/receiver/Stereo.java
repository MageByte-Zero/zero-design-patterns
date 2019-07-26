package com.zero.headfirst.command.receiver;

public class Stereo {
    public void on() {
        System.out.println("打开音响");
    }

    public void off() {
        System.out.println("关闭音响");
    }

    public void setCD() {
        System.out.println("放入CD");
    }

    public void setVolume() {
        System.out.println("音响音量设置为20");
    }
}
