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
     * @param key
     * @return
     */
    public V get(String key) {
        V value = null;
        //读取缓存
        readLock.lock();
        try {
            value = DATA_MAP.get(key);
        } finally {
            readLock.unlock();
        }
        // 缓存中存在，直接返回
        if (Objects.nonNull(value)) {
            return value;
        }
        writeLock.lock();
        try {
            // 再次验证是否为空，可能其他写线程已经查询郭数据库写到缓存中了，后续再次获取到写锁的线程就不用再次查数据库
            value = DATA_MAP.get(key);
            if (Objects.isNull(value)) {
                //模拟查询数据库
                value = (V) "queryFromDB";
                DATA_MAP.put(key, value);
            }
        } finally {
            writeLock.unlock();
        }
        return value;

    }

    /**
     * 写缓存
     * @param key
     * @param value
     * @return
     */
    public V put(String key, V value) {
        writeLock.lock();
        try {
            return DATA_MAP.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
}
