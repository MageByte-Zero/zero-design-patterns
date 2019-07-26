package com.zero.headfirst.observer;

public interface Observer {
    /**
     * 接收主题发布的更新通知
     */
    void notice(Newspaper data);
}
