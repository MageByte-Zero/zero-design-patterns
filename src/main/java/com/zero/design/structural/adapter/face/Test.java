package com.zero.design.structural.adapter.face;

/**
 * Created by unique on 2017/5/13.
 */
public class Test {

    public static void main(String[] args) {
        Sourceable sourceableSub1 = new SourceableSub1();
        Sourceable sourceableSub2 = new SourceableSub2();

        sourceableSub1.method1();
        sourceableSub1.method2();

        sourceableSub2.method1();
        sourceableSub2.method2();
    }
}
