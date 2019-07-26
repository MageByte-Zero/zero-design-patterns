package com.zero.design.actions.observers.local;

/**
 * Created by jianqing.li on 2017/6/8.
 */
public class ObserverTest {
    public static void main(String[] args) {
        // 创建主题
        NumsObservable numsObservable = new NumsObservable();
        //创建订阅者
        OddObserver oddObserver = new OddObserver();
        EvenObserver evenObserver = new EvenObserver();
        numsObservable.addObserver(oddObserver);
        numsObservable.addObserver(evenObserver);

        //修改主题内容，触发notifyObservers
        numsObservable.setData(11);
        numsObservable.setData(12);
        numsObservable.setData(13);

    }
}
