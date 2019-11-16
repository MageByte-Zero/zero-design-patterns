package com.zero.test;

import com.zero.concurrent.Cache;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ReentrantReadWriteLockTest {

    private Cache<String, String> cache;

    @Before
    public void before() {
        cache = new Cache<>();
        cache.put("init", "初始数据");
    }

    @Test
    public void testGet() {
        for (int j = 0; j < 10; j++) { //写入
            final String key = "key" + j;
            new Thread(new Runnable() {
                public void run() {
                    cache.put(key, key);
                }
            }).start();
            new Thread(new Runnable() { //读取
                public void run() {
                    cache.get(key);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
