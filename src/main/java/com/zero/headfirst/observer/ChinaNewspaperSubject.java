package com.zero.headfirst.observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ChinaNewspaperSubject implements NewspaperSubject {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private List<Observer> observers;

    public ChinaNewspaperSubject() {
        this.observers = new ArrayList<>();
    }

    public void setChange() {
        Newspaper newspaper = new Newspaper();
        newspaper.setReportTime(LocalDateTime.now());
        newspaper.setData("发布新闻");
        notifyObservers(newspaper);
    }

    @Override
    public void registerObserver(Observer observer) {
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        try {
            writeLock.lock();
            observers.add(observer);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        try {
            writeLock.lock();
            observers.remove(observer);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void notifyObservers(Newspaper data) {
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        try {
            readLock.lock();
            observers.forEach(item -> item.notice(data));
        } finally {
            readLock.unlock();
        }
    }
}
