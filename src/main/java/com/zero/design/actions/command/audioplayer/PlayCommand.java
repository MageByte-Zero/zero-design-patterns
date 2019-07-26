package com.zero.design.actions.command.audioplayer;

/**
 * 播放具体命令角色
 * Created by ljq97 on 2017/8/13.
 */
public class PlayCommand implements Command {

    /**
     * 持有接收者角色对象，实现执行对应命令动作
     */
    private AudioPlayer audioPlayer;

    /**
     * 执行方法
     */
    @Override
    public void execute() {
        audioPlayer.play();
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public void setAudioPlayer(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }
}
