package com.zero.headfirst.observer;

public class Test {
    public static void main(String[] args) {
        ChinaNewspaperSubject newspaperSubject = new ChinaNewspaperSubject();
        HonKongObserver honKongObserver = new HonKongObserver();
        newspaperSubject.registerObserver(honKongObserver);
        newspaperSubject.setChange();

    }
}
