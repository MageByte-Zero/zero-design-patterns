package com.zero.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 洗茶壶、洗茶杯、拿茶叶任务
 */
public class PrepareTeaTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("PrepareTeaTask:洗茶壶...");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("PrepareTeaTask:洗茶杯...");
        TimeUnit.SECONDS.sleep(2);

        System.out.println("PrepareTeaTask:拿茶叶...");
        TimeUnit.SECONDS.sleep(1);
        return "龙井";
    }
}
