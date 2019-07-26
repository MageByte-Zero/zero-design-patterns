package com.zero.design.actions.command.audioplayer;

/**
 * 客户端角色
 * Created by ljq97 on 2017/8/13.
 */
public class Julia {
    public static void main(String[] args) {
        //创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        //创建命令对象,指定命令对应的接收者
        PlayCommand playCommand = new PlayCommand();
        playCommand.setAudioPlayer(audioPlayer);

        RewindCommand rewindCommand = new RewindCommand();
        rewindCommand.setAudioPlayer(audioPlayer);

        StopCommand stopCommand = new StopCommand();
        stopCommand.setAudioPlayer(audioPlayer);

        //创建请求者对象,并设置指令
        KeyPad keyPad = new KeyPad();
        keyPad.setPlayCommand(playCommand);
        keyPad.setRewindCommand(rewindCommand);
        keyPad.setStopCommand(stopCommand);

        //测试
        keyPad.play();
        keyPad.rewind();
        keyPad.stop();
    }
}
