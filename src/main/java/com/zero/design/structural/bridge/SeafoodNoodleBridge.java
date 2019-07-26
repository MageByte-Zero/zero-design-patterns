package com.zero.design.structural.bridge;

/**
 * Created by unique on 2017/5/14.
 */
public class SeafoodNoodleBridge extends NoodleBridge {

    public SeafoodNoodleBridge() {
    }

    public SeafoodNoodleBridge(Style style) {
        super(style);
    }

    @Override
    protected String getNoodleName() {
        return "三鲜";
    }
}
