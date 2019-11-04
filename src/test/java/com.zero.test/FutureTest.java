package com.zero.test;

import com.zero.concurrent.future.ComputeTask;
import com.zero.concurrent.future.TeaService;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureTest {

    ExecutorService pool = Executors.newFixedThreadPool(4);

    @After
    public void after() {
        pool.shutdown();
    }

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        TeaService teaService = new TeaService();
        teaService.makeTea();
    }

    @Test
    public void testComputeTask() throws InterruptedException, ExecutionException {
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(pool);
        int taskSize = 4;
        for (int i = 0; i < taskSize; i++) {
            completionService.submit(new ComputeTask());
        }
        for (int i = 0; i < taskSize; i++) {
            System.out.println(completionService.take().get());
        }
    }
}
