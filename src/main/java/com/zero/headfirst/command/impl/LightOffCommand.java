package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;
import com.zero.headfirst.command.receiver.Light;

public class LightOffCommand implements Command {

    /**
     * 持有接受者实例，以便当命令execute执行的时候由接受者执行
     */
    private Light light;

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }

    public void setLight(Light light) {
        this.light = light;
    }
}
