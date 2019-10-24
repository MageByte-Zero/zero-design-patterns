package com.zero.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Running {

    public static void main(String[] args) throws InterruptedException {

        int n = 6;
        CountDownLatch doneSignal = new CountDownLatch(n);
        Executor e = Executors.newFixedThreadPool(6);

        for (int i = 0; i < n; ++i) {
            e.execute(new Runner("doneSignal" + i, doneSignal));
        }
        //等待所有跑男就位
        System.out.println("所有运动员就位，计时开始");
        // 当 doneSignal 每次执行 countDown 操作，变成了 0 之后所有线程唤醒执行
        doneSignal.await();
    }

}

class Runner implements Runnable {

    private String name;
    private final CountDownLatch doneSignal;

    public Runner(String name, CountDownLatch doneSignal) {
        this.name = name;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println("name = " + name + "开跑");
        } finally {
            //
            doneSignal.countDown();
        }
    }
}
