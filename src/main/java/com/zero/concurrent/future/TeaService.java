package com.zero.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TeaService {

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void makeTea() throws ExecutionException, InterruptedException {
        PrepareTeaTask prepareTeaTask = new PrepareTeaTask();
        Future<String> prepareTeaTaskFuture = executorService.submit(prepareTeaTask);

        BoilWaterTask boilWaterTask = new BoilWaterTask(prepareTeaTaskFuture);
        Future<String> boilWaterTaskFuture = executorService.submit(boilWaterTask);
        System.out.println(boilWaterTaskFuture.get());

    }
}
