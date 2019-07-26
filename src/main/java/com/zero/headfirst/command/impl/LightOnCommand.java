package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;
import com.zero.headfirst.command.receiver.Light;

public class LightOnCommand implements Command {

    /**
     * 持有接受者实例，以便当命令execute执行的时候由接受者执行开灯
     */
    private Light light;

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

    /**
     * 设置命令的接受者
     * @param light
     */
    public void setLight(Light light) {
        this.light = light;
    }
}
