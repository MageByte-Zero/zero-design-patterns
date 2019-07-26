package com.zero.headfirst.states;

/**
 * 没有硬币状态
 */
public class NoCoinState implements MachineState {
    private MachineContext machineContext;

    public NoCoinState(MachineContext machineContext) {
        this.machineContext = machineContext;
    }

    @Override
    public void handleRequest() {
        System.out.println("你没有投币，请先投币。");
    }
}
