package com.zero.concurrent.future;

import java.util.Random;
import java.util.concurrent.Callable;

public class ComputeTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        int sleepTime = new Random().nextInt(1000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 返回给调用者的值
        String name = Thread.currentThread().getName();
        String result = name + " sleep time:" + sleepTime;
        System.out.println(name + " finished...");

        return result;
    }
}
