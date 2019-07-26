package com.zero.design.actions.Memento.more;

/**
 * Created by ljq97 on 2017/8/20.
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker(originator);

        //改变状态
        originator.setState("state 0");
        //建立一个检查点
        caretaker.createMemento();

        originator.setState("state 1");
        caretaker.createMemento();
        originator.setState("state 2");
        caretaker.createMemento();
        originator.setState("state 3");
        caretaker.createMemento();

        originator.printStates();
        System.out.println("------恢复检查点-------");

        caretaker.restoreMemento(2);
        //打印出所有检查点
        originator.printStates();
    }
}
