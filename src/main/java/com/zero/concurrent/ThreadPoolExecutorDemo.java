package com.zero.concurrent;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8
            , 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(200), new NamedThreadFactory("my exec pool-", false),
            new CustomizeDiscardPolicy());


    public void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    /**
     * 自定义拒绝策略
     */
    public static class CustomizeDiscardPolicy implements RejectedExecutionHandler {

        public CustomizeDiscardPolicy() {
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task " + r.toString() + " rejected from " + executor.toString());
        }
    }
}
