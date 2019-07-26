package com.zero.design.actions.Memento.white;

/**
 * 负责人角色：负责人角色负责保存备忘录对象，但是从不修改（甚至不查看）备忘录对象的内容。
 * Created by ljq97 on 2017/8/13.
 */
public class Caretaker {
    private Memento memento;

    /**
     * 备忘录取值方法
     * @return
     */
    public Memento retreveMemento() {
        return this.memento;
    }

    /**
     * 备忘录赋值方法
     * @param memento
     */
    public void saveMemento(Memento memento) {
        this.memento = memento;
    }
}
