package com.zero.headfirst.states;

/**
 * 售罄状态
 */
public class SellOutState implements MachineState {
    private MachineContext machineContext;

    public SellOutState(MachineContext machineContext) {
        this.machineContext = machineContext;
    }

    @Override
    public void handleRequest() {
        System.out.println("汽水售罄,退回你的硬币");
    }
}
