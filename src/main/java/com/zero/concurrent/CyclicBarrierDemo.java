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
                    // 每个运动员执行到这就会 对 N - 1，变为 0 则放一波线程运行，然后重置 N
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
