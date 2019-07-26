package com.zero.design.actions.Memento.self;

/**
 * Created by ljq97 on 2017/8/20.
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        //修改状态
        originator.changeState("state 0");

        //创建备忘录
        IMemento memento = originator.createMemento();

        //修改
        originator.changeState("state 1");
        //恢复
        originator.restoreMemento(memento);
    }
}

