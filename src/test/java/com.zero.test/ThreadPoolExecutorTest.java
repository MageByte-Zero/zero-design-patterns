package com.zero.test;

import com.zero.concurrent.ThreadPoolExecutorDemo;
import org.junit.Test;

public class ThreadPoolExecutorTest {
    @Test
    public void testRun() {
        ThreadPoolExecutorDemo threadPoolExecutorDemo = new ThreadPoolExecutorDemo();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPoolExecutorDemo.execute(() -> System.out.println(Thread.currentThread().getName() + finalI));
        }

    }
}
