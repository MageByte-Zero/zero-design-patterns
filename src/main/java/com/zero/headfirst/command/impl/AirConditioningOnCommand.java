package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;
import com.zero.headfirst.command.receiver.AirConditioning;

public class AirConditioningOnCommand implements Command {

    private AirConditioning airConditioning;

    public void setAirConditioning(AirConditioning airConditioning) {
        this.airConditioning = airConditioning;
    }

    @Override
    public void execute() {
        airConditioning.on();
        airConditioning.setTemperature();
    }

    @Override
    public void undo() {
        airConditioning.off();
    }
}
