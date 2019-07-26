package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;
import com.zero.headfirst.command.receiver.Stereo;

/**
 * 音响开指令
 */
public class StereoOnCommand implements Command {

    private Stereo stereo;

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume();
    }

    @Override
    public void undo() {
        stereo.off();
    }

    public void setStereo(Stereo stereo) {
        this.stereo = stereo;
    }
}
