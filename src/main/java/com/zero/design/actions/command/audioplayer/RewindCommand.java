package com.zero.design.actions.command.audioplayer;

/**
 * 倒带具体命令角色类
 * Created by ljq97 on 2017/8/13.
 */
public class RewindCommand implements Command {
    /**
     * 持有接收者角色对象，实现执行对应命令动作
     */
    private AudioPlayer audioPlayer;

    @Override
    public void execute() {
        audioPlayer.rewind();
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public void setAudioPlayer(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }
}
