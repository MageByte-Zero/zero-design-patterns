package com.zero.design.actions.Memento.more;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人角色
 * Created by ljq97 on 2017/8/20.
 */
public class Caretaker {
    private Originator originator;

    private List<Memento> mementos = new ArrayList<Memento>();

    private int current;

    public Caretaker(Originator originator) {
        this.originator = originator;
        this.current = 0;
    }

    /**
     * 创建一个新的检查点
     * @return
     */
    public int createMemento() {
        Memento memento = originator.createMemento();
        mementos.add(memento);
        return current++;

    }

    /**
     * 将发起人恢复到某个检查点
     * @param index
     */
    public void restoreMemento(int index) {
        Memento memento = mementos.get(index);
        originator.restoreMemento(memento);
    }

    /**
     * 将某个检查点删除
     * @param index
     */
    public void removeMemento(int index) {
        mementos.remove(index);
    }
}
