package com.zero.headfirst.factory;

import com.zero.headfirst.factory.product.CPU;
import com.zero.headfirst.factory.product.IntelCPU;
import com.zero.headfirst.factory.product.IntelMainboard;
import com.zero.headfirst.factory.product.Mainboard;

public class IntelFactory implements MainboardCPUFactory {

    @Override
    public CPU createCpu() {
        return new IntelCPU(755);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }

}