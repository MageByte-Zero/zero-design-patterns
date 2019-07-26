package com.zero.design.actions.Memento.black;

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
    public IMemento createMemento() {
        return new Memento(state);
    }

    /**
     * 将发起人恢复到备忘录对象所记载的历史状态内容
     * @param memento
     */
    public void restoreMemento(IMemento memento) {
        //恢复发起人状态
        this.setState(((Memento)memento).getState());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }

    /**
     * 私有化备忘录角色
     */
    private class Memento implements IMemento {
        private String state;
        /**
         * 构造方法
         */
        private Memento(String state){
            this.state = state;
        }

        private String getState() {
            return state;
        }
        private void setState(String state) {
            this.state = state;
        }
    }
}
