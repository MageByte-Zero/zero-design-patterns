package com.zero.concurrent;

import java.util.concurrent.*;

public class CyclicBarrierDemo {

    private CyclicBarrier cyclicBarrier;

    private ExecutorService executorService;

    public CyclicBarrierDemo(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        executorService = Executors.newFixedThreadPool(cyclicBarrier.getParties());
    }

    public void startRun() {

        for (int i = 0; i < cyclicBarrier.getParties() * 3; i++) {
            int current = i;
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "运动员，准备就绪");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "运动员，开跑");
                    TimeUnit.SECONDS.sleep(current);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
