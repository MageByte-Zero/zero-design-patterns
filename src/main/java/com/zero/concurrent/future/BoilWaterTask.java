package com.zero.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 洗水壶、烧开水,并等待泡茶预备任务完成的结果执行泡茶
 */
public class BoilWaterTask implements Callable<String> {

    private Future<String> prepareTeaFuture;

    public BoilWaterTask(Future<String> prepareTeaFuture) {
        this.prepareTeaFuture = prepareTeaFuture;
    }

    @Override
    public String call() throws Exception {
        System.out.println("BoilWaterTask:洗水壶...");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("BoilWaterTask:烧开水...");
        TimeUnit.SECONDS.sleep(15);
        // 获取T2线程的茶叶
        String prepareTeaResult = prepareTeaFuture.get();
        System.out.println("BoilWaterTask:拿到茶叶:" + prepareTeaResult);

        System.out.println("BoilWaterTask:泡茶...");
        return "上茶:" + prepareTeaResult;
    }
}
