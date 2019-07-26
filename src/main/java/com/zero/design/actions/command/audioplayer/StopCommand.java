package com.zero.design.actions.command.audioplayer;

/**
 * 停止播放具体命令角色
 * Created by ljq97 on 2017/8/13.
 */
public class StopCommand implements Command {

    /**
     * 命令接收者对象
     */
    private AudioPlayer audioPlayer;

    @Override
    public void execute() {
        audioPlayer.stop();
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public void setAudioPlayer(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }
}
