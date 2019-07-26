package com.zero.design.structural.bridge;

/**
 * 通过NoodleBridge类的调用，实现了对接口Style的实现类HotStyle、LightStyle
 * 的调用
 * Created by unique on 2017/5/15.
 */
public class Client {

    public static void main(String[] args) {
        NoodleBridge noodleBridge = new BeefNoodleBridge();
        /**
         * 通过setStyle实例化风味
         */
        noodleBridge.setStyle(new HotStyle());
        noodleBridge.eat();
        noodleBridge.setStyle(new LightStyle());
        noodleBridge.eat();
        System.out.println("---------------------");

        /**
         * 通过构造方法实例化风味
         */
        noodleBridge = new SeafoodNoodleBridge(new HotStyle());
        noodleBridge.eat();
        noodleBridge = new SeafoodNoodleBridge(new LightStyle());
        noodleBridge.eat();


    }
}
