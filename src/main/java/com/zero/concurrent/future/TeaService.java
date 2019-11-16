package com.zero.concurrent.future;

import java.util.concurrent.*;

public class TeaService {

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void makeTea() throws ExecutionException, InterruptedException {
        FutureTask<String> prepareTeaFutureTask = new FutureTask<>(new PrepareTeaTask());
        FutureTask<String> boilWaterFutureTask = new FutureTask<>(new BoilWaterTask(prepareTeaFutureTask));

        executorService.submit(prepareTeaFutureTask);
        executorService.submit(boilWaterFutureTask);

        System.out.println(boilWaterFutureTask.get());
        executorService.shutdown();

    }
}
