package com.zero.headfirst.factory;

import com.zero.headfirst.factory.product.AmdCpu;
import com.zero.headfirst.factory.product.AmdMainboard;
import com.zero.headfirst.factory.product.CPU;
import com.zero.headfirst.factory.product.Mainboard;

public class AmdFactory implements MainboardCPUFactory {

    @Override
    public CPU createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard(938);
    }

}