package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;
import com.zero.headfirst.command.receiver.TV;

public class TVOffCommand implements Command {
    private TV tv;

    public void setTv(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
        tv.setChannel();
        tv.setVolume();
    }
}
