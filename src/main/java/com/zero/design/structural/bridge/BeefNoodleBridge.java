package com.zero.design.structural.bridge;

/**
 * 牛肉面；
 * 不同桥实现，这阿姨那个客户端就可以设定所需要的桥取桥接实现目的
 * Created by unique on 2017/5/14.
 */
public class BeefNoodleBridge extends NoodleBridge {
    public BeefNoodleBridge() {
    }

    /**
     * 可通过构造方法实例化风味，也可以通过set、get
     * @param style
     */
    public BeefNoodleBridge(Style style) {
        super(style);
    }

    @Override
    protected String getNoodleName() {
        return "牛肉";
    }
}
