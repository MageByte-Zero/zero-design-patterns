package com.zero.design.actions.Memento.self;

/**
 * 发起人角色同时还兼任负责人角色，
 * 也就是说它自己负责保持自己的备忘录对象
 * Created by ljq97 on 2017/8/20.
 */
public class Originator {

    private String state;

    /**
     * 改变状态
     * @param state
     */
    public void changeState(String state) {
        this.state = state;
        System.out.println("状态改变为：" + state);
    }

    /**
     * 工厂方法，返回新的备忘录对象
     * @return
     */
    public Memento createMemento() {
        return new Memento(this);
    }

    /**
     * 将发起人恢复到备忘录对象所记录的状态上
     * @param memento
     */
    public void restoreMemento(IMemento memento) {
        Memento m = (Memento) memento;
        changeState(m.getState());
    }

    private class Memento implements IMemento {
        private String state;

        public Memento(Originator originator) {
            this.state = originator.state;
        }

        private String getState() {
            return state;
        }

    }
}
