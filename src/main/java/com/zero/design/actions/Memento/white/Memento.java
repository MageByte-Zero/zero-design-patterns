package com.zero.design.actions.Memento.white;

/**
 * 备忘录角色：备忘录对象将发起人对象传入的状态存储起来。
 * Created by ljq97 on 2017/8/13.
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
