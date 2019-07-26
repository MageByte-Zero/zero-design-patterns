package com.zero.design.actions.Memento.white;

/**
 * 发起人角色:发起人角色利用一个新创建的备忘录对象将自己的内部状态存储起来
 * Created by ljq97 on 2017/8/13.
 */
public class Originator {

    /**
     * 待备忘内容
     */
    private String state;

    /**
     * 工厂方法，返回一个新的备忘录对象
     * @return
     */
    public Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 将发起人恢复到备忘录对象所记载的历史状态内容
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
        System.out.println("当前状态：" + this.state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }
}
