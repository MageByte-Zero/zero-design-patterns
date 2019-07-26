/**
 * 被观察者--主题类
 * <p>两个私有静态变量,分别变化
 * <p>被两个订阅者订阅,分别关注不同的兴趣点--奇数变化 OR 偶数变化
 */
package com.zero.design.actions.observers.local;

import java.util.Observable;

/**
 * 主题类
 * Created by jianqing.li on 2017/6/8.
 */
public class NumsObservable extends Observable {
    public final static Integer ODD = 1;
    public final static Integer EVEN = 2;

    private int data = 0;

    /**
     * 获取对象数据
     *
     * @return
     */
    public int getData() {
        return data;
    }

    /**
     * 设置数据变化
     * 根据数据的变化设置相应的标志变量,通知给订阅者
     *
     * @param data
     */
    public void setData(int data) {
        this.data = data;
        Integer flag = EVEN;
        if ((this.data & 0x0001) == 1) {
            flag = ODD;
        }
        setChanged();
        // 将变化的变化的标识变量通知给订阅者
        notifyObservers(flag);
    }
}
