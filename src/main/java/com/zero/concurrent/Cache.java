package com.zero.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {

    private final Map<K, V> DATA_MAP = new HashMap<>();

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
     * 读取缓存
     * @param key
     * @return
     */
    public V get(K key) {
        readLock.lock();
        try {
            return DATA_MAP.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 写缓存
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        writeLock.lock();
        try {
            return DATA_MAP.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
}
