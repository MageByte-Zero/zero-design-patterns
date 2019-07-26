package com.zero.design.actions.command.audioplayer;

/**
 * 接收者(Receiver)角色，负责执行命令
 * Created by ljq97 on 2017/8/13.
 */
public class AudioPlayer {
    public void play() {
        System.out.println("播放---");
    }

    public void rewind() {
        System.out.println("倒带...");
    }

    public void stop() {
        System.out.println("停止...");
    }
}
