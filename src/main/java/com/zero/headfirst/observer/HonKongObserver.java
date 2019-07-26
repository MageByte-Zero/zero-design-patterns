package com.zero.headfirst.observer;

public class HonKongObserver implements Observer {

    @Override
    public void notice(Newspaper data) {
        System.out.println("我收到报社的报纸了：" + "内容是" + data.toString());
    }
}
