package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;
import com.zero.headfirst.command.receiver.Stereo;

public class StereoOffCommand implements Command {

    private Stereo stereo;

    public void setStereo(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume();
    }
}
