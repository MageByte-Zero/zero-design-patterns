package com.zero.design.actions.Memento.white;

/**
 * 客户端角色
 * Created by ljq97 on 2017/8/13.
 */
public class Client {
    public static void main(String[] args) {
        Originator o = new Originator();
        Caretaker c = new Caretaker();

        //设置负责人对象的状态
        o.setState("Off");

        //创建备忘录对象，并将发起人对象的状态存储起来
        c.saveMemento(o.createMemento());

        //修改发起人对象的状态
        o.setState("On");

        //恢复发起人对象的状态
        o.restoreMemento(c.retreveMemento());

        System.out.println(o.getState());
    }
}
