package com.zero.test;

import com.zero.concurrent.CyclicBarrierDemo;
import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemoTest {

    @Test
    public void testRun() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("所有运动员准备就绪，裁判发令..."));
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(cyclicBarrier);
        cyclicBarrierDemo.startRun();
        Thread.currentThread().join();
    }
}
