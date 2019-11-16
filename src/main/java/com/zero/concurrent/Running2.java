package com.zero.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Running2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);

        int number = 4;
        CountDownLatch doneSignal = new CountDownLatch(number);

        ExecutorService executorService = Executors.newFixedThreadPool(number);
        for (int i = 0; i < number; i++) {
            final int currnt = i;
            executorService.execute(() -> {
                try {
                    startSignal.await();
                    System.out.println(Thread.currentThread().getName() + "迈开步子使劲跑");
                    TimeUnit.SECONDS.sleep(currnt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    doneSignal.countDown();
                    System.out.println(Thread.currentThread().getName() + "到达终点");
                }
            });
        }
        System.out.println("裁判员发号施令啦！！！");
        startSignal.countDown();
        doneSignal.await();
        System.out.println("所有运动员到达终点，比赛结束!");

        executorService.shutdown();

    }
}
