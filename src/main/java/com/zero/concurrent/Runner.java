package com.zero.concurrent;

import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable {

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
            // 对计数器 - 1
            doneSignal.countDown();
        }
    }
}