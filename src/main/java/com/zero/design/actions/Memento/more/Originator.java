package com.zero.design.actions.Memento.more;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljq97 on 2017/8/16.
 */
public class Originator {

    private List<String> states;

    /**
     * 检查点指数
     */
    private int index;

    /**
     * 构造函数初始化呆备份数据数组
     */
    public Originator() {
        this.states = new ArrayList<>();
        this.index = 0;
    }

    /**
     * 工厂方法，返还一个新的备忘录对象
     * @return
     */
    protected Memento createMemento() {
        return new Memento(states, index);
    }

    /**
     * 将发起人恢复到备忘录对象记录的状态上
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        this.states = memento.getStates();
        this.index = memento.getIndex();
    }

    /**
     * 状态赋值
     * @param state
     */
    public void setState(String state) {
        states.add(state);
        index++;
    }

    public void printStates() {
        for (String state : states) {
            System.out.println(state);
        }
    }

}
