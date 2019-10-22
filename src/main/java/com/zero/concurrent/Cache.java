package com.zero.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<String, V> {

    private final Map<String, V> DATA_MAP = new HashMap<>();

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 读锁
     */
    private final Lock readLock = readWriteLock.readLock();

    /**
     * 写锁
     */
    private final Lock writeLock = readWriteLock.writeLock();

    /**
     * 读取缓存,若缓存不存在则查找数据库并放到缓存
     *
     * @param key
     * @return
     */
    public V get(String key) {
        readLock.lock();
        System.out.println("开始读取缓存数据....." + Thread.currentThread().getName());
        V value = DATA_MAP.get(key);
        //缓存中不存在，释放读锁获取写锁
        if (Objects.isNull(value)) {
            // 若 value 为空则先释放读锁，并且让该线程获取写锁，而其他线程只能等待该写锁释放
            // 必须先释放读锁才能去获取写锁，读锁还没有释放，此时获取写锁，会导致写锁永久等待，最终导致相关线程都被阻塞，永远也没有机会被唤醒。锁的升级是不允许的，这个你一定要注意。
            readLock.unlock();
            writeLock.lock();
            // 再次检查状态，因为其他线程可能已经获取到写锁且更新了状态
            try {
                if (Objects.isNull(value)) {
                    //模拟查询数据库
                    value = (V) "queryFromDB";
                    DATA_MAP.put(key, value);
                }
                // 通过在释放写锁之前获取读锁来实现锁降级，降级为读锁
                readLock.lock();
            } finally {
                // 释放写锁，依然持有读锁
                writeLock.unlock();
            }
        }

        //当前还持有读锁,所以最后还要释放读锁
        try {
            System.out.println(Thread.currentThread().getName() + "-- 读 : {key:" + key + ",value: " + value + "}");
            return value;
        } finally {
            System.out.println("结束读取缓存数据....." + Thread.currentThread().getName());
            readLock.unlock();
        }

    }

    /**
     * 写缓存
     *
     * @param key
     * @param value
     * @return
     */
    public V put(String key, V value) {
        writeLock.lock();
        System.out.println("开始写入缓存数据....." + Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + "-- 写 :  {key:" + key + ",value: " + value + "}");
            return DATA_MAP.put(key, value);
        } finally {
            System.out.println("结束写入缓存数据....." + Thread.currentThread().getName());
            writeLock.unlock();
        }
    }

    /**
     * 清空缓存
     */
    public void clear() {
        writeLock.lock();
        try {
            DATA_MAP.clear();
        } finally {
            writeLock.unlock();
        }
    }
}
