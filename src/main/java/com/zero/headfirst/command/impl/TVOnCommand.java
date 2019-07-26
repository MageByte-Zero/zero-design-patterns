package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;
import com.zero.headfirst.command.receiver.TV;

public class TVOnCommand implements Command {

    private TV tv;

    public void setTv(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
        tv.setChannel();
        tv.setVolume();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
