
package com.zero.design.actions.Memento.black;

/**
 * Created by ljq97 on 2017/8/15.
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        //初始化负责人状态
        originator.setState("On");
        //创建备忘录角色,并将发起人的状态保存起来
        caretaker.saveMemento(originator.createMemento());

        //修改发起人状态
        originator.setState("Off");

        //在恢复发起人原始状态
        originator.restoreMemento(caretaker.retrieveMemento());
    }
}
