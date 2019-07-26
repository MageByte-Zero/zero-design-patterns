package com.zero.design.actions.observers.local;

import java.util.Observable;
import java.util.Observer;

/**
 * 偶数内容订阅类:订阅主题的内容的偶数变化
 * Created by jianqing.li on 2017/6/8.
 */
public class EvenObserver implements Observer {

    /**
     * 继承自Observer接口类,update的方法的实现
     *
     * @param o   主题对象
     * @param arg notifyObservers(flag);传来的参数,即是标识变量
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg == NumsObservable.EVEN) {
            NumsObservable numsObservable = (NumsObservable) o;
            System.out.println("Data has changed to EVEN number " + numsObservable.getData());
        }
    }
}
