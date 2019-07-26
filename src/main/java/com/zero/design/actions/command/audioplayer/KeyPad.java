package com.zero.design.actions.command.audioplayer;

/**
 * 请求者角色，由键盘类扮演,包含所有具体命令角色对象
 * Created by ljq97 on 2017/8/13.
 */
public class KeyPad {
    private PlayCommand playCommand;
    private RewindCommand rewindCommand;
    private StopCommand stopCommand;

    /**
     * 执行播放方法
     */
    public void play() {
        playCommand.execute();
    }

    /**
     * 执行倒带方法
     */
    public void rewind() {
        rewindCommand.execute();
    }

    /**
     * 执行播放方法
     */
    public void stop() {
        stopCommand.execute();
    }

    public void setPlayCommand(PlayCommand playCommand) {
        this.playCommand = playCommand;
    }

    public void setRewindCommand(RewindCommand rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(StopCommand stopCommand) {
        this.stopCommand = stopCommand;
    }
}
